import axios from "axios";
import config from "../config";
import { ElMessage } from "element-plus";
import router from "../router";
import storage from "./storage";

const NETWORK_ERROR = "网络请求异常，请稍后再试";

const instance = axios.create({
    baseURL: config.baseApi,
    timeout: 8000,
});

//请求拦截
instance.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    const headers = config.headers;
    if(storage.getItem('userInfo')){
        console.log("141251"+storage.getItem('userInfo').data)
        const {accessToken} = storage.getItem('userInfo').data || {token:""};
        if (!headers.Authorization) headers.Authorization = "Bearer " + accessToken; //jwt token
    }
    return config;
});

//响应拦截
// instance.interceptors.response.use(function (response) {
//     const { code, msg } = response.data; //状态码  接口  HTTP
//     if (code === 200) {
//         response.data;
//     } else if (code === 50001) {
//         ElMessage.error(msg);
//         setTimeout(() => {
//             router.push("/login");
//         }, 3000);
//         return Promise.reject(msg);
//     } else {
//         ElMessage.error(msg || NETWORK_ERROR);
//     }
//     return response;
// });
instance.interceptors.response.use(
    function (response) {
        // 处理2xx状态码响应
        const { code, msg } = response.data;
        if (code === 200) {
            // response.data;
            return response;
        } else if (code === 50001) {
            ElMessage.error(msg);
            setTimeout(() => {
                router.push("/login");
            }, 300);
            return Promise.reject(msg);
        } else {
            ElMessage.error(msg || NETWORK_ERROR);
        }
        return response;
    },
    function (error) {
        // 处理非2xx状态码响应
        if (error.response && error.response.data) {
            const { msg, code } = error.response.data;
            if (code === 401) {
                ElMessage.error(msg || "认证失败");
                setTimeout(() => {
                    router.push("/login");
                }, 3000);
            } else {
                ElMessage.error(msg || NETWORK_ERROR);
            }
        } else {
            ElMessage.error(NETWORK_ERROR);
        }
        return Promise.reject(error);
    }
);

function request(options) {
    options.method = options.method || "get";
    if (options.method.toLowerCase() === "get") {
        options.params = options.data;
    }

    let isMock = config.mock;    //全局的配置
    if(toString.call(options.mock) !== '[object Undefined]'){  //用户配置
        isMock = options.mock;
    }

    if (config.env === "prod") {
        instance.defaults.baseURL = config.baseApi;
    } else {
        console.log(isMock)
        console.log(config.mockApi)
        instance.defaults.baseURL = isMock ? config.mockApi : config.baseApi;

    }
    return instance(options);
}

// 遍历HTTP方法数组，为request对象动态添加方法
["get", "post", "put", "delete"].forEach((item) => {
    // 为每个方法创建快捷调用方式（函数式API）
    request[item] = (url, data, mock) => {
        // ====== 参数重载逻辑 ======
        // 场景1：未传递data参数时，初始化空对象
        if(data === undefined){
            data = {};  // 避免后续操作空指针异常
        }

        // 场景2：当data参数为布尔类型时，实为mock标识
        // 说明用户意图通过第二个参数设置mock标志
        if(typeof data == "boolean"){
            mock = data;  // 将mock参数前移赋值
            data = {};    // 重置data为空对象
        }

        // 最终调用基础request方法，合并配置项
        return request({
            url,      // 接口路径
            data,     // 请求体/查询参数（根据方法类型自动适配）
            mock,     // mock开关标识
            method: item,  // 当前HTTP方法（来自数组遍历）
        });
    };
});

export default request;

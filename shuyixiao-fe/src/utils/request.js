import axios from "axios";
import config from "../config";
import {ElMessage} from "element-plus";

const NETWORK_ERROR = "网络请求异常，请稍后重试";

const instance = axios.create({
  baseURL: config.baseUrl,
  timeout: 5000,
});

// 添加请求拦截器
axios.interceptors.request.use(function (config){
    const headers = config.headers;
    if (!headers.Authorization) headers.Authorization = "";
    return config;
});

// 添加响应拦截器
axios.interceptors.response.use(function (response){
    const { code, message} = response.data;
    if (code === 200) {
        return response.data;
    } else {
        ElMessage.error(message || NETWORK_ERROR);
        return Promise.reject(message || NETWORK_ERROR);
    }
    return response;
});

function request(options) {
    options.method = options.method || "get";
    if (options.method.toLowerCase() === "get") {
        options.params = options.data;
    }

    if (config.env == "prod"){
        instance.defaults.baseURL = config.baseApi;
    }else {
        instance.defaults.baseURL = config.mock ? config.mockApi : config.baseApi;
    }
    return instance(options);
}

export default request;
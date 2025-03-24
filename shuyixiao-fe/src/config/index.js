const env = import.meta.env.MODE || 'development';
const envConfig = {
    dev: {
        baseApi: "/api",
        mockApi: "",
    },
    test: {
        baseApi: "",
        mockApi: "",
    },
    prod:{
        baseApi: "",
        mockApi: "",
    },

};
// 环境配置
export default {
    env,
    mock: true,
    nameSpace: "manager",
    ...envConfig[env]
}
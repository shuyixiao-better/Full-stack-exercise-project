const env = import.meta.env.MODE || 'development';
const envConfig = {
    dev: {
        baseApi: "",
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
    ...envConfig[env]
}
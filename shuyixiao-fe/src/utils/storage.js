import config from "../config";

export default {
    setItem(key, value){
        const storage = this.getStorage();
        storage[key] = value;
        localStorage.setItem(config.nameSpace, JSON.stringify(storage))
    },

    getItem(key){
        return this.getStorage()[key];
    },
    getStorage(){
        return JSON.parse(localStorage.getItem(config.nameSpace))
        // 检查 localStorage 中是否存在对应的存储项
        // const storage = localStorage.getItem(config.nameSpace);
        // if (storage) {
        //     return JSON.parse(storage);
        // } else {
        //     // 如果不存在，初始化一个空对象
        //     return {};
        // }
    },
    // 清空
    clearItem(key){
        let storage = this.getStorage();
        delete storage[key];
        localStorage.setItem(config.nameSpace, JSON.stringify(storage))
    },
    // 清空所有
    clearAll(){
        localStorage.clear();
    },

}
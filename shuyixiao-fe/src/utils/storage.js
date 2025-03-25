import config from "../config";

export default {
    setItem(key, value) {
        //const storage = localStorage.getItem(config.nameSpace) || {};
        const storage = this.getStorage();
        storage[key] = value;
        localStorage.setItem(config.nameSpace, JSON.stringify(storage));
    },
    getItem(key) {
        return this.getStorage()[key];
    },
    getStorage() {
        return JSON.parse(localStorage.getItem(config.nameSpace)) || {};
    },
    //清空某一项item (原生clear 清空所有)
    clearItem(key) {
        let storage = this.getStorage();
        delete storage[key];
        localStorage.setItem(config.nameSpace, JSON.stringify(storage));
    },
    //清空所有item
    clearAll() {
        localStorage.clear();
    },
};
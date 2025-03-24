import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './style.css'
import App from './App.vue'
import router from "./router/index";
import axios from "axios";
import config from "./config";

// 根路径+接口地址
// axios.get();
const app = createApp(App)
app.use(router);
app.use(ElementPlus);
app.mount('#app')

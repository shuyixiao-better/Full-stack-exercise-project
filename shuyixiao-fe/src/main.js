import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './style/index.css'
import './style.css'
import App from './App.vue'
import router from "./router/index";
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import store from "./store"

// 根路径+接口地址
// axios.get();
const app = createApp(App)
app.use(router);
app.use(store);
app.use(ElementPlus);
app.mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

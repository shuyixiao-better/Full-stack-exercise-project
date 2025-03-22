import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../components/Home.vue";
import Welcome from "../components/Welcome.vue";
import Detail from "../components/Detail.vue";

const routes = [
    {
        path: "/", //根路径
        name: "home",
        component: Home,
        children: [
            //设置子路由  当 / 匹配成功  welcome 将被渲染到 home 的 <router-view> 内部
            {
                path: "/welcome",
                name: "welcome",
                component: Welcome,
            },
            {
                path: "/detail",
                name: "detail",
                component: Detail,
            },
        ],
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;

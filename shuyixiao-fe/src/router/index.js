import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../components/Home.vue";

const routes = [
    {
        path: "/", //根路径
        name: "home",
        component: Home,
        redirect: "/welcome", //重定向到子路由 welcome 将被渲染到 home 的 <router-view> 内部
        meta: {
            title: "首页",
        },
        children: [
            //设置子路由  当 / 匹配成功  welcome 将被渲染到 home 的 <router-view> 内部
            {
                path: "/welcome",
                name: "welcome",
                component: () => import("../components/Welcome.vue"),
                meta: {
                    title: "欢迎页",
                },
            },
            {
                path: "/detail",
                name: "detail",
                component: () => import("../components/Detail.vue"),
            },
        ],
    },
    {
        path: "/login",
        name: "login",
        component: () => import("../views/Login.vue"),
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;

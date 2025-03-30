/**
 * API 管理
 */
import request from "../utils/request";
export function login(data){
    return request.post("/user/login",data);
}

export function notify(){
    return request.get("/notify/count");
}

export function menuList(){
    return request.get("/menu/list");
}
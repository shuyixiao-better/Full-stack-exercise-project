package shuyixiao.config;

import shuyixiao.data.UserData;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName ResponseData.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:02:00
 */
public class ResponseData {
    private int code;
    private UserData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}

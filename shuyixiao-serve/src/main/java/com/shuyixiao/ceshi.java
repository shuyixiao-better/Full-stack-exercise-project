package shuyixiao;

import java.io.Serializable;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName ceshi.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 00:43:00
 */
public class ceshi implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ceshi() {
    }

    public ceshi(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ceshi{" +
                "code='" + code + '\'' +
                '}';
    }
}

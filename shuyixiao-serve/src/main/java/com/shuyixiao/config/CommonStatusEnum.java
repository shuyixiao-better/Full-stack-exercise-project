package shuyixiao.config;

import lombok.Getter;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName CommonStatusEnum.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年04月06日 20:36:00
 */
public enum CommonStatusEnum {

    /**
     * 成功
     */
    SUCCESS(1,"success"),
    /**
     * 失败
     */
    FAIL(0,"fail")

    ;
    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}

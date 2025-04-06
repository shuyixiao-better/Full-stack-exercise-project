package shuyixiao.config;

import lombok.Data;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName TokenResponse.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年04月06日 20:43:00
 */
@Data
public class TokenResponse {

    private String accessToken;

    private String refreshToken;
}
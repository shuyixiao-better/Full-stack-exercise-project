package shuyixiao.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import shuyixiao.config.*;

import java.util.concurrent.TimeUnit;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName VerificationCodeService.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年04月06日 20:34:00
 */
@Service
public class VerificationCodeService {


    @Autowired
    StringRedisTemplate stringRedisTemplate;


    public ResponseResult checkCode(String userName, String passWord) {

        // 颁发令牌，不应该用魔法值，用常量
        String accessToken = JwtUtils.generatorToken(userName, passWord, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(userName, passWord ,TokenConstants.REFRESH_TOKEN_TYPE);

        // 将token存到redis当中
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(userName , passWord , TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey , accessToken , 30, TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(userName , passWord , TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey , refreshToken , 31, TimeUnit.DAYS);

        // 响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }
}

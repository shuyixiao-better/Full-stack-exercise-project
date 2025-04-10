package shuyixiao.config;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName RedisPrefixUtils.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年04月06日 20:38:00
 */
public class RedisPrefixUtils {

    // 乘客验证码的前缀
    public static String verificationCodePrefix = "verification-code-";

    // token存储的前缀
    public static String tokenPrefix = "token-";

    // 黑名单设备号
    public static String blackDeviceCodePrefix = "black-device-";

    /**
     * 根据手机号，生成key
     * @param phone
     * @param identity
     * @return
     */
    public static String generatorKeyByPhone(String phone, String identity){
        return verificationCodePrefix + identity+ "-" + phone;
    }

    /**
     * 根据手机号和身份标识，生成token
     * @param phone
     * @param identity
     * @return
     */
    public static String generatorTokenKey(String phone , String identity , String tokenType){
        return tokenPrefix + phone + "-" + identity + "-" + tokenType;
    }
}

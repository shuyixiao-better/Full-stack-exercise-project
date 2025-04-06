package shuyixiao.data;

import lombok.Data;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName UserData.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:01:00
 */
@Data
public class UserData {
    private int userId = 10005;
    private String userName = "舒一笑不秃头";
    private String userEmail = "yixiaoshu88@163.com";
    private String userPass = "SDgeWerweAfdGrqd";
    private int state = 1;
    private int[] depId = {};
    private int role = 0;
    private String token;
    private String refreshToken;
    private int[] roleList = {};
}


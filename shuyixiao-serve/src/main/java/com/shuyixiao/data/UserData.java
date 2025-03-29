package shuyixiao.data;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName UserData.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:01:00
 */
public class UserData {
    private int userId = 10005;
    private String userName = "舒一笑不秃头";
    private String userEmail = "yixiaoshu88@163.com";
    private String userPass = "SDgeWerweAfdGrqd";
    private int state = 1;
    private int[] depId = {};
    private int role = 0;
    private String token = "1667466179";
    private int[] roleList = {};

    // Getter 和 Setter 方法
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int[] getDepId() {
        return depId;
    }

    public void setDepId(int[] depId) {
        this.depId = depId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int[] getRoleList() {
        return roleList;
    }

    public void setRoleList(int[] roleList) {
        this.roleList = roleList;
    }
}


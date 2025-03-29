package shuyixiao.data;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName AuditFlow.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:11:00
 */
public class AuditFlow {
    private String _id;
    private String userId;
    private String userName;
    private String userEmail;

    public AuditFlow(String s, String number, String lee, String mail) {
    }

    // Getter 和 Setter 方法
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
}

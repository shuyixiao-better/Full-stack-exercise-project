package shuyixiao.config;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName Log.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:11:00
 */
public class Log {
    private String _id;
    private String userId;
    private String userName;
    private String createTime;
    private String remark;
    private String action;

    public Log(String s, String number, String lee, String s1, String 同意, String 审核通过) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

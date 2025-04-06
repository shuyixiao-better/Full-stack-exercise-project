package shuyixiao.config;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import shuyixiao.data.Menu;
import shuyixiao.data.UserData;

import java.util.List;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName ResponseData.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:02:00
 */
@Data
public class ResponseData {

    private int code;

    private List<Menu> menuList;

    private UserData data;

    private Integer count;

    private String msg;

    private String message;
}

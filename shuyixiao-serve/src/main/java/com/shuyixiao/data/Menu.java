package shuyixiao.data;

import lombok.Data;

import java.util.List;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName Menu.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月30日 12:50:00
 */
@Data
public class Menu {
    private List<String> parentId;
    private String updateTime;
    private String createTime;
    private String _id;
    private int __v;
    private int menuType;
    private String menuName;
    private String icon;
    private String menuCode;
    private String path;
    private String order;
    private String component;
    private int menuState;
    private List<Menu> children; // 嵌套的子菜单
    private List<Menu> action;

}

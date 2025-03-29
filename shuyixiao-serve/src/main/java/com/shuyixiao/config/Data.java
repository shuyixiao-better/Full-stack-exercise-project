package shuyixiao.config;

import shuyixiao.data.Item;

import java.util.List;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName Data.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:10:00
 */
public class Data {
    private Page page;
    private List<Item> list;

    // Getter 和 Setter 方法
    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}

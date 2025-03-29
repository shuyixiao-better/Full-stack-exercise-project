package shuyixiao.config;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName Page.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月29日 10:10:00
 */
public class Page {
    private int pageNum;
    private int pageSize;
    private int total;

    // Getter 和 Setter 方法
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

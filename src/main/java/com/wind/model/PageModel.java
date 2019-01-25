package com.wind.model;

/**
 * PageModel
 *
 * @author qianchun
 * @date 2019/1/25
 **/
public class PageModel {

    private int pageNum;

    private int pageSize;

    public PageModel(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (this.pageNum - 1) * this.pageSize;
    }

    public int getLimit() {
        return pageSize;
    }
}

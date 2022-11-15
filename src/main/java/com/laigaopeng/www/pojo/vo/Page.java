package com.laigaopeng.www.pojo.vo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 20;

    private Integer pageNum; // 当前页数

    private Integer pageSize = PAGE_SIZE; // 一页所展示的记录数列

    private Integer pageSum; // 总页数

    private Integer recordSum; // 总记录数

    private List<T> items; // 当前页记录数据

    private Integer begin; // LIMIT begin使用

    public Page(Integer pageNum, Integer recordSum) {
        this.pageNum = pageNum;
        this.recordSum = recordSum;
        this.pageSum = this.recordSum / this.pageSize + ((this.recordSum % this.pageSize > 0) ? 1 : 0);
        this.begin = (this.pageNum - 1) * this.pageSize;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum < 1) pageNum = 1;
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSum() {
        return pageSum;
    }

    public void setPageSum(Integer pageSum) {
        this.pageSum = pageSum;
    }

    public Integer getRecordSum() {
        return recordSum;
    }

    public void setRecordSum(Integer recordSum) {
        this.recordSum = recordSum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

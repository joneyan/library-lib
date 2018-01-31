package com.lib.bean;

import java.util.List;

/**
 * Created by Administrator on 2018-1-31.
 */
public class PageBean<T> {
    private Integer page;
    private Integer pagesize;
    private Integer totalNum;
    private Integer totalPage;
    private List<T> pageElements;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        this.totalPage = (totalNum + pagesize - 1) / pagesize;
    }

    public List<T> getPageElements() {
        return pageElements;
    }

    public void setPageElements(List<T> pageElements) {
        this.pageElements = pageElements;
    }
}

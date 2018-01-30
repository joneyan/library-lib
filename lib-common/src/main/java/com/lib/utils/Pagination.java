package com.lib.utils;

import java.util.List;
import java.util.Map;

public interface Pagination<T> {
    /*是否是第一页*/
    boolean isFirstPage();
    /*是否是最后一页*/
    boolean isLastPage();
    /*是否有下一页*/
    boolean hasNextPage();
    /*是否有上一页*/
    boolean hasPreviousPage();
    /*获取第一页页码*/
    int getFirstPageNumber();
    /*获取最后一页页码*/
    int getLastPageNumber();
    /*获取这一页的数据*/
    List<T> getThisPageElements();
    /*获取数据的多少*/
    int getTotalNumberOfElements();

    int getThisPageFirstElementNumber();

    int getThisPageLastElementNumber();

    int getNextPageNumber();

    int getPreviousPageNumber();

    /*获取页面大小*/
    int getPageSize();
    /*获取页面*/
    int getPageNumber();
    /*获取数据*/
    Map<String, Object> getModel();
    
    List<T> getcurPageElements();
}

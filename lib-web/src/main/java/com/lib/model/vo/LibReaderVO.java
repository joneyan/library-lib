package com.lib.model.vo;

import com.lib.model.LibReader;

public class LibReaderVO extends LibReader{
    private Integer isBanner; //是否是查询禁用名单
    private String readerType; //读者类型
    private String gender; //性别
    private String domanager; //最近操作者名字

    public String getDomanager() {
        return domanager;
    }

    public void setDomanager(String domanager) {
        this.domanager = domanager;
    }

    public Integer getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(Integer isBanner) {
        this.isBanner = isBanner;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

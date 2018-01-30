package com.lib.model;

public class LibPress {
    private String pubname /* 出版社名字 */;

    private Integer id /*  */;

    private Integer status /* 可用状态（0不可用，1可用） */;

    public String getPubname(){

        return pubname;
    }
    public void setPubname(String pubname){

        this.pubname = pubname;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public Integer getStatus(){

        return status;
    }
    public void setStatus(Integer status){

        this.status = status;
    }
}

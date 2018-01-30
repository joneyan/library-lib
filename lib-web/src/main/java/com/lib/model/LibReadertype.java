package com.lib.model;

public class LibReadertype {
    private Integer brownum /* 该类型可借书数量 */;

    private String rolename /* 读者类型名字 */;

    private Integer id /*  */;

    public Integer getBrownum(){

        return brownum;
    }
    public void setBrownum(Integer brownum){

        this.brownum = brownum;
    }
    public String getRolename(){

        return rolename;
    }
    public void setRolename(String rolename){

        this.rolename = rolename;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
}

package com.lib.model;

public class LibManager {
    private String password /* 密码 */;

    private Integer id /*  */;

    private String username /* 管理员名字 */;
    private Integer status; /*是否是超级管理员*/

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword(){

        return password;
    }
    public void setPassword(String password){

        this.password = password;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public String getUsername(){

        return username;
    }
    public void setUsername(String username){

        this.username = username;
    }
}

package com.lib.model;

public class LibLibrary {
    private String libarayname /* 图书馆名字 */;

    private String curator /* 图书馆长 */;

    private String address /* 图书馆地址 */;

    private java.util.Date createdate /* 创立时间 */;

    private String tel /* 图书馆电话 */;

    private Integer id /*  */;

    private String email /* 图书馆邮箱 */;

    public String getLibarayname(){

        return libarayname;
    }
    public void setLibarayname(String libarayname){

        this.libarayname = libarayname;
    }
    public String getCurator(){

        return curator;
    }
    public void setCurator(String curator){

        this.curator = curator;
    }
    public String getAddress(){

        return address;
    }
    public void setAddress(String address){

        this.address = address;
    }
    public java.util.Date getCreatedate(){

        return createdate;
    }
    public void setCreatedate(java.util.Date createdate){

        this.createdate = createdate;
    }
    public String getTel(){

        return tel;
    }
    public void setTel(String tel){

        this.tel = tel;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public String getEmail(){

        return email;
    }
    public void setEmail(String email){

        this.email = email;
    }
}

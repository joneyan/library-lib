package com.lib.model;

public class LibBooktype {
    private Integer days /* 书籍类可借天数 */;

    private Integer id /*  */;

    private String typename /* 书籍类别名字 */;

    public Integer getDays(){

        return days;
    }
    public void setDays(Integer days){

        this.days = days;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public String getTypename(){

        return typename;
    }
    public void setTypename(String typename){

        this.typename = typename;
    }
}

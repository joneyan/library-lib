package com.lib.model;

public class LibReader {
    private java.util.Date birthday /* 读者生日 */;

    private Integer remainum /* 还能借的数量 */;

    private String sex /* 读者性别 */;

    private java.util.Date bannertime /* 封禁到什么时候 */;

    private java.util.Date createdate /* 创建日期 */;

    private String remark /* 备注 */;

    private Integer operator /* 操作者（创建或者修改信息） */;

    private String readertel /* 读者手机 */;

    private String vocation /* 读者职业 */;

    private String readermail /* 邮箱 */;

    private String papertype /* 读者证件类型 */;

    private java.util.Date updatedate /* 修改日期 */;

    private String name /* 读者名字 */;

    private String papernum /* 读者证件号码 */;

    private Integer typeid /* 读者类型 */;

    private Integer id /*  */;

    private String barcode /* 读者条形码 */;

    public java.util.Date getBirthday(){

        return birthday;
    }
    public void setBirthday(java.util.Date birthday){

        this.birthday = birthday;
    }
    public Integer getRemainum(){

        return remainum;
    }
    public void setRemainum(Integer remainum){

        this.remainum = remainum;
    }
    public String getSex(){

        return sex;
    }
    public void setSex(String sex){

        this.sex = sex;
    }
    public java.util.Date getBannertime(){

        return bannertime;
    }
    public void setBannertime(java.util.Date bannertime){

        this.bannertime = bannertime;
    }
    public java.util.Date getCreatedate(){

        return createdate;
    }
    public void setCreatedate(java.util.Date createdate){

        this.createdate = createdate;
    }
    public String getRemark(){

        return remark;
    }
    public void setRemark(String remark){

        this.remark = remark;
    }
    public Integer getOperator(){

        return operator;
    }
    public void setOperator(Integer operator){

        this.operator = operator;
    }
    public String getReadertel(){

        return readertel;
    }
    public void setReadertel(String readertel){

        this.readertel = readertel;
    }
    public String getVocation(){

        return vocation;
    }
    public void setVocation(String vocation){

        this.vocation = vocation;
    }
    public String getReadermail(){

        return readermail;
    }
    public void setReadermail(String readermail){

        this.readermail = readermail;
    }
    public String getPapertype(){

        return papertype;
    }
    public void setPapertype(String papertype){

        this.papertype = papertype;
    }
    public java.util.Date getUpdatedate(){

        return updatedate;
    }
    public void setUpdatedate(java.util.Date updatedate){

        this.updatedate = updatedate;
    }
    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name = name;
    }
    public String getPapernum(){

        return papernum;
    }
    public void setPapernum(String papernum){

        this.papernum = papernum;
    }
    public Integer getTypeid(){

        return typeid;
    }
    public void setTypeid(Integer typeid){

        this.typeid = typeid;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public String getBarcode(){

        return barcode;
    }
    public void setBarcode(String barcode){

        this.barcode = barcode;
    }
}

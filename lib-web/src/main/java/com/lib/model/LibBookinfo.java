package com.lib.model;

public class LibBookinfo {
    private java.util.Date intime /* 入馆时间 */;

    private String author /* 作者 */;

    private String isbn /* 国际图书标准编号 */;

    private Integer operator /* 操作者 */;

    private Integer leftnum /* 剩下数量 */;

    private Integer totalnum /* 书籍总数 */;

    private Integer price /* 价格 */;

    private Integer bookcaseid /* 书架 */;

    private Integer pressid /* 出版社id */;

    private Integer typeid /* 书籍类别Id */;

    private Integer id /*  */;

    private Integer page /* 页数 */;

    private String bookname /* 书籍名字 */;

    private String barcode /* 书籍条码 */;

    private Integer status /* 状态（0为不上架，1为上架） */;

    public java.util.Date getIntime(){

        return intime;
    }
    public void setIntime(java.util.Date intime){

        this.intime = intime;
    }
    public String getAuthor(){

        return author;
    }
    public void setAuthor(String author){

        this.author = author;
    }
    public String getIsbn(){

        return isbn;
    }
    public void setIsbn(String isbn){

        this.isbn = isbn;
    }
    public Integer getOperator(){

        return operator;
    }
    public void setOperator(Integer operator){

        this.operator = operator;
    }
    public Integer getLeftnum(){

        return leftnum;
    }
    public void setLeftnum(Integer leftnum){

        this.leftnum = leftnum;
    }
    public Integer getTotalnum(){

        return totalnum;
    }
    public void setTotalnum(Integer totalnum){

        this.totalnum = totalnum;
    }
    public Integer getPrice(){

        return price;
    }
    public void setPrice(Integer price){

        this.price = price;
    }
    public Integer getBookcaseid(){

        return bookcaseid;
    }
    public void setBookcaseid(Integer bookcaseid){

        this.bookcaseid = bookcaseid;
    }
    public Integer getPressid(){

        return pressid;
    }
    public void setPressid(Integer pressid){

        this.pressid = pressid;
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
    public Integer getPage(){

        return page;
    }
    public void setPage(Integer page){

        this.page = page;
    }
    public String getBookname(){

        return bookname;
    }
    public void setBookname(String bookname){

        this.bookname = bookname;
    }
    public String getBarcode(){

        return barcode;
    }
    public void setBarcode(String barcode){

        this.barcode = barcode;
    }
    public Integer getStatus(){

        return status;
    }
    public void setStatus(Integer status){

        this.status = status;
    }
}

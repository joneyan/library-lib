package com.lib.model;

public class LibBookborrow {
    private java.util.Date backTime /* 归还日期 */;

    private Integer readerId /* 读者id */;

    private java.util.Date stipulateTime /* 规定归还日期 */;

    private Integer id /*  */;

    private Integer bookId /* 书籍id */;

    private java.util.Date borrowTime /* 借书日期 */;

    private Integer operator /* 操作者（创建或者修改信息） */;

    private Integer status /* 归还状态（1归还，0没有归还） */;

    public java.util.Date getBackTime(){

        return backTime;
    }
    public void setBackTime(java.util.Date backTime){

        this.backTime = backTime;
    }
    public Integer getReaderId(){

        return readerId;
    }
    public void setReaderId(Integer readerId){

        this.readerId = readerId;
    }
    public java.util.Date getStipulateTime(){

        return stipulateTime;
    }
    public void setStipulateTime(java.util.Date stipulateTime){

        this.stipulateTime = stipulateTime;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public Integer getBookId(){

        return bookId;
    }
    public void setBookId(Integer bookId){

        this.bookId = bookId;
    }
    public java.util.Date getBorrowTime(){

        return borrowTime;
    }
    public void setBorrowTime(java.util.Date borrowTime){

        this.borrowTime = borrowTime;
    }
    public Integer getOperator(){

        return operator;
    }
    public void setOperator(Integer operator){

        this.operator = operator;
    }
    public Integer getStatus(){

        return status;
    }
    public void setStatus(Integer status){

        this.status = status;
    }
}

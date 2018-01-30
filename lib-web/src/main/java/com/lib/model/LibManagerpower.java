package com.lib.model;

public class LibManagerpower {
    private Integer bookset /* 书籍设置 1,0 */;

    private Integer borrowback /* 借还设置 1,0 */;

    private Integer readerset /* 读者设置 1,0 */;

    private Integer sysset /* 系统设置 1,0 */;

    private Integer id /*  */;

    private Integer sysquery /* 查询设置 1,0 */;

    public Integer getBookset(){

        return bookset;
    }
    public void setBookset(Integer bookset){

        this.bookset = bookset;
    }
    public Integer getBorrowback(){

        return borrowback;
    }
    public void setBorrowback(Integer borrowback){

        this.borrowback = borrowback;
    }
    public Integer getReaderset(){

        return readerset;
    }
    public void setReaderset(Integer readerset){

        this.readerset = readerset;
    }
    public Integer getSysset(){

        return sysset;
    }
    public void setSysset(Integer sysset){

        this.sysset = sysset;
    }
    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public Integer getSysquery(){

        return sysquery;
    }
    public void setSysquery(Integer sysquery){

        this.sysquery = sysquery;
    }
}

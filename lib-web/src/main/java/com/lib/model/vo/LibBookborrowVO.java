package com.lib.model.vo;

import com.lib.model.LibBookborrow;

import java.text.DecimalFormat;

public class LibBookborrowVO extends LibBookborrow{
    private String readerName;
    private String manaName;
    private String bookname;
    private Double totalBorrow;
    private String  pecent;

    public String getPecent() {
        return pecent;
    }

/*    public void setPecent(Double total) {

        this.pecent = (this.totalBorrow/total)*100+"%";
    }*/

    public void setPecent(String pecent) {
        this.pecent = pecent;
    }

    public Double getTotalBorrow() {
        return totalBorrow;
    }

    public void setTotalBorrow(Double totalBorrow) {
        this.totalBorrow = totalBorrow;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getManaName() {
        return manaName;
    }

    public void setManaName(String manaName) {
        this.manaName = manaName;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}

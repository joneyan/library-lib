package com.lib.model.vo;

import com.lib.model.LibBookborrow;

public class LibBookborrowVO extends LibBookborrow{
    private String readerName;
    private String manaName;
    private String bookname;

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

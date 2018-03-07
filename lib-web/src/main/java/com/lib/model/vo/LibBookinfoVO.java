package com.lib.model.vo;

import com.lib.model.LibBookinfo;

public class LibBookinfoVO extends LibBookinfo{
    private String pressname;//出版社名字
    private String catename;//类名
    private String casename;
    public String getPressname() {
        return pressname;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCatename() {

        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public void setPressname(String pressname) {
        this.pressname = pressname;
    }
}

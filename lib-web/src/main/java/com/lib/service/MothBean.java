package com.lib.service;

import java.text.NumberFormat;

/**
 * Created by JONEYAN on 2018/3/22.
 */
public class MothBean {
    private Integer count;
    private double radio;
    private String finalradio;
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getFinalradio() {
        return finalradio;
    }

    public void setFinalradio() {

        NumberFormat nFromat = NumberFormat.getPercentInstance();
        finalradio = nFromat.format(radio);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}

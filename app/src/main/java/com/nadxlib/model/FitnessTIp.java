package com.nadxlib.model;

public class FitnessTIp {
    String title,des;

    public FitnessTIp(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public FitnessTIp(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

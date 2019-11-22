package com.example.viewpagertrail;

public class backgrounds {

    public String getUrladdress() {
        return urladdress;
    }

    public void setUrladdress(String urladdress) {
        this.urladdress = urladdress;
    }

    backgrounds(int resid, String title, String urladdress) {
        this.resid = resid;
        this.title = title;
        this.urladdress = urladdress;

    }

    private int resid;
    private String title;
    private String urladdress;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }
}

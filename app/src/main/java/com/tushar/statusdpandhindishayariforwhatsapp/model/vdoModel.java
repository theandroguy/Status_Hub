package com.tushar.statusdpandhindishayariforwhatsapp.model;

import java.io.Serializable;

public class vdoModel implements Serializable {
    public String title,url;

    public vdoModel(String title, String desc, String url) {
        this.title = title;

        this.url = url;
    }

    public  vdoModel()
    {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

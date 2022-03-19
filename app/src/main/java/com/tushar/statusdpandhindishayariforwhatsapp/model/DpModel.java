package com.tushar.statusdpandhindishayariforwhatsapp.model;

import java.io.Serializable;

public class DpModel implements Serializable {

    public String dpurl;

    public DpModel() {

    }



    public String getDpurl() {
        return dpurl;
    }

    public void setDpurl(String dpurl) {
        this.dpurl = dpurl;
    }
    public DpModel(String dpurl) {
        this.dpurl = dpurl;
    }
}

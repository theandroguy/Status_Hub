package com.tushar.statusdpandhindishayariforwhatsapp.model;

import java.io.Serializable;

public class attitude_cat implements Serializable {
    public String at;
    public  attitude_cat()
    {

    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public attitude_cat(String at) {
        this.at = at;
    }
}

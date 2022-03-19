package com.tushar.statusdpandhindishayariforwhatsapp.model;

import android.widget.Button;

import java.io.Serializable;

public class StatusModel implements Serializable {
    public String st;


     StatusModel()
    {

    }


    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public StatusModel(String st) {
        this.st = st;
    }
}

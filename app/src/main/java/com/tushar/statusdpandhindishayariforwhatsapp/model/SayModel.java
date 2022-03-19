package com.tushar.statusdpandhindishayariforwhatsapp.model;

import java.io.Serializable;

public class SayModel implements Serializable {

    public String saya;

    public SayModel()
    {

    }

    public String getSaya() {
        return saya;
    }

    public void setSaya(String saya) {
        this.saya = saya;
    }

    public SayModel(String saya) {
        this.saya = saya;
    }
}

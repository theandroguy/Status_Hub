package com.tushar.statusdpandhindishayariforwhatsapp.model;

import java.io.Serializable;

public class TrendingModel implements Serializable {
    public String meme;

    public TrendingModel()
    {

    }

    public String getMeme() {
        return meme;
    }

    public void setMeme(String meme) {
        this.meme = meme;
    }

    public TrendingModel(String meme) {
        this.meme = meme;
    }
}

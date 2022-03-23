package com.example.torang_core.data.model;

import java.util.ArrayList;

public class Advertisement {

    /**
     Default constructor
     */
    public Advertisement() {
    }
    
    public boolean hasMedia() {
        return medias != null && medias.size() > 0;
    }

    /**
     *
     */
    public int ad_id;

    /**
     *
     */
    public ArrayList<AdMedia> medias;
}

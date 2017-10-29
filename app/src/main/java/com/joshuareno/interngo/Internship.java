package com.joshuareno.interngo;

import android.media.Image;

/**
 * Created by joshuareno on 10/28/17.
 */

public abstract class Internship {
    public String company;
    private int level;
    public String logo;

    public Internship(String company, int level, String logo) {
        this.company = company;
        this.level = level;
        this.logo = logo;
    }

    public int getLevel() {
        return level;
    }

    public Internship getInstance() {
        return this;
    }

    public abstract Attack[] getAttacks();
}

package com.joshuareno.interngo;

import android.media.Image;

/**
 * Created by joshuareno on 10/28/17.
 */

public abstract class Internship {
    public String company;
    public int level;
    public Image logo;

    public Internship(String company, int level, Image logo) {
        this.company = company;
        this.level = level;
        this.logo = logo;
    }

    public Internship getInstance() {
        return this;
    }

    public abstract Attack[] getAttacks();

    public abstract void attack();
}

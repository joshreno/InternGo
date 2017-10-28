package com.joshuareno.interngo;

import android.media.Image;

/**
 * Created by joshuareno on 10/28/17.
 */

public class Internship {
    public Attack[] attack;
    public String company;
    public int level;
    public String position;
    public Image logo;

    public Internship(Attack[] attack, String company, int level, String position, Image logo) {
        this.attack = attack;
        this.company = company;
        this.level = level;
        this.position = position;
        this.logo = logo;
    }

    public Internship getInstance() {
        return this;
    }

    public Attack[] getAttacks() {
        return attack;
    }

    public Attack getRandomAttack() {
        double random = attack.length * Math.random() + 1;
        return attack[(int) random];
    }
}

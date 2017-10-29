package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class Attack {
    private String name;
    private int damage;

    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}

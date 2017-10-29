package com.joshuareno.interngo;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by joshuareno on 10/28/17.
 */

public abstract class Internship implements Serializable {
    private String company;
    private int level;
    private int xp;
    private int health;
    private int maxHealth;
    private int logoID;

    public Internship(String company, int level, int logoID) {
        this.company = company;
        this.level = level;
        this.logoID = logoID;
        xp = 0;
        maxHealth = (int)(20 * Math.pow(level, 0.5));
        health = maxHealth;
    }

    public void increaseXP(int amount) {
        xp += amount;
        if (xp > 20 * Math.pow(level, 0.5)) {
            levelUp();
        }
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        maxHealth = (int)(20 * Math.pow(level, 0.5));
    }

    public String getCompany() {
        return company;
    }

    public int getLogoID() {
        return logoID;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() { return maxHealth; }

    public void damage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal() {
        health = maxHealth;
    }

    public boolean catchSuccess() {
        boolean result = (Math.random() < 0.5 + 0.5 * (maxHealth - health) / maxHealth);
        return result;
    }

    public Internship getInstance() {
        return this;
    }

    public abstract Attack[] getAttacks();

    public String generateAttack(Internship opponent) {
        Attack[] attacks = getAttacks();
        int number = (int)(attacks.length * Math.random());
        return attacks[number].attack(opponent);
    }
}

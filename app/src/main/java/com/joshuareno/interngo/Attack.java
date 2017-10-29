package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class Attack {
    private Internship owner;
    private String name;
    private int damage;

    public Attack(Internship owner, String name, int damage) {
        this.owner = owner;
        this.name = name;
        this.damage = damage;
    }

    public Internship getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int attack(Internship opponent) {
        double ownerValue;
        if (owner instanceof SoftwareInternship) {
            ownerValue = 1;
        } else if (owner instanceof ManufacturingInternship) {
            ownerValue = 2;
        } else if (owner instanceof LogisticsInternship) {
            ownerValue = 3;
        } else {
            ownerValue = 0.5;
        }
        double opponentValue;
        if (opponent instanceof SoftwareInternship) {
            opponentValue = 1;
        } else if (opponent instanceof ManufacturingInternship) {
            opponentValue = 2;
        } else if (opponent instanceof LogisticsInternship) {
            opponentValue = 3;
        } else {
            opponentValue = 0.5;
        }

        double difference = ownerValue - opponentValue;
        if (difference == 2) {
            difference = -1;
        } else if (difference == -2) {
            difference = 1;
        }

        if (difference == 1) {
            return (int)(damage * 1.5 * Math.pow(owner.getLevel(), 0.5));
        } else if (difference == -1) {
            return (int)(damage * 0.66 * Math.pow(owner.getLevel(), 0.5));
        } else {
            return (int)(damage * Math.pow(owner.getLevel(), 0.5));
        }
    }

}

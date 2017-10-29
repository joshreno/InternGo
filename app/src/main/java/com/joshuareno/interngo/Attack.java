package com.joshuareno.interngo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by aberc on 10/28/2017.
 */

public class Attack implements Serializable {
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

    public String attack(Internship opponent) {
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

        int damageDealt;
        if (difference == 1) {
            damageDealt = (int)(damage * 1.5 * Math.pow(owner.getLevel(), 0.5));
        } else if (difference == -1) {
            damageDealt =  (int)(damage * 0.66 * Math.pow(owner.getLevel(), 0.5));
        } else {
            damageDealt = (int)(damage * Math.pow(owner.getLevel(), 0.5));
        }

        boolean criticalAttack = false;
        if (Math.random() > 0.8) {
            criticalAttack = true;
            damage *= 1.5;
        }

        opponent.damage(damageDealt);

        String description = owner.getCompany() + " used " + name + ".";
        if (criticalAttack) {
            description += " It was a critical attack!";
        }
        if (difference == 1) {
            description += " It was super effective!";
        } else if (difference == -1) {
            description += " It wasn't very effective.";
        }

        return description;

    }

    public int describeContents() {
        return 0;
    }

}

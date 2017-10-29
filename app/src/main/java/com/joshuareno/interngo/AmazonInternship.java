package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class AmazonInternship extends LogisticsInternship {

    private Attack[] attacks;

    public AmazonInternship(int level) {
        super("Amazon", level, R.drawable.amazon);
        attacks = new Attack[2];
        attacks[0] = new Attack(this, "Deliver products", 20);
        attacks[1] = new Attack(this, "Sell groceries", 10);
    }

    public Attack[] getAttacks() {
        return attacks;
    }

}

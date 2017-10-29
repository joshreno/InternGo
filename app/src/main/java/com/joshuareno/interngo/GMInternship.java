package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class GMInternship extends ManufacturingInternship {

    private Attack[] attacks;

    public GMInternship(int level) {
        super("General Motors", level, R.drawable.general_motors);
        attacks = new Attack[2];
        attacks[0] = new Attack(this, "Drive in circles", 15);
        attacks[1] = new Attack(this, "Rev engine", 10);
    }

    public Attack[] getAttacks() {
        return attacks;
    }

}

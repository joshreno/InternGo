package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class TeslaInternship extends ManufacturingInternship {

    private Attack[] attacks;

    public TeslaInternship(int level) {
        super("Tesla", level, R.drawable.tesla);
        attacks = new Attack[2];
        attacks[0] = new Attack(this, "Charge", 10);
        attacks[1] = new Attack(this, "Use autopilot", 15);
    }

    public Attack[] getAttacks() {
        return attacks;
    }

}

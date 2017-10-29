package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class HomeDepotInternship extends LogisticsInternship {

    private Attack[] attacks;

    public HomeDepotInternship(int level) {
        super("Home Depot", level, R.drawable.home_depot);
        attacks = new Attack[2];
        attacks[0] = new Attack(this, "Build project", 10);
        attacks[1] = new Attack(this, "Line shelves", 15);
    }

    public Attack[] getAttacks() {
        return attacks;
    }

}

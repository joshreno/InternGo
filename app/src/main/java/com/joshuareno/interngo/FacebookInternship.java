package com.joshuareno.interngo;

/**
 * Created by aberc on 10/28/2017.
 */

public class FacebookInternship extends SoftwareInternship {

    private Attack[] attacks;

    public FacebookInternship(int level) {
        super("Facebook", level, R.drawable.facebook);
        attacks = new Attack[2];
        attacks[0] = new Attack(this, "Like", 10);
        attacks[1] = new Attack(this, "Friend request", 15);
    }

    public Attack[] getAttacks() {
        return attacks;
    }

}

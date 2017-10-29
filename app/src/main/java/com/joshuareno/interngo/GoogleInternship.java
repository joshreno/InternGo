package com.joshuareno.interngo;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by aberc on 10/28/2017.
 */

public class GoogleInternship extends SoftwareInternship {

    private Attack[] attacks;

    public GoogleInternship(int level) {
        super("Google", level, "google.jpg");
        attacks = new Attack[2];
        attacks[0] = new Attack(this, "Google answer", 10);
        attacks[1] = new Attack(this,"Program Android", 15);
    }

    public Attack[] getAttacks() {
        return attacks;
    }

}

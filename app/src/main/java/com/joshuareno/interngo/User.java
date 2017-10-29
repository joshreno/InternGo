package com.joshuareno.interngo;

import java.util.ArrayList;

/**
 * Created by aberc on 10/28/2017.
 */

public class User {

    String name;
    ArrayList<Internship> internships;
    ArrayList<Internship> storedInternships;

    public User(String name) {
        this.name = name;
        internships = new ArrayList<>();
        storedInternships = new ArrayList<>();
    }

    public void addInternship(Internship internship) {
        if (internships.size() >= 5) {
            storedInternships.add(internship);
        } else {
            internships.add(internship);
        }
    }

    public Internship getFirstInternship() {
        if (internships.size() == 0) {
            return null;
        } else {
            return internships.get(0);
        }
    }

}

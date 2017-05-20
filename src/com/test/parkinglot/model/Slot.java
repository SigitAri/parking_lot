package com.test.parkinglot.model;

/**
 * Created by Sigit on 20/05/2017.
 */
public class Slot {
    private int id;
    private String registration;
    private String colour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}

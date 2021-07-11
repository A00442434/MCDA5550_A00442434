package com.example.hotelreservationsk.controllers.entities;

public class Confirmation {
    private String confirmation_number;

    public String getConfirmation_number() {
        return String.valueOf(Math.random()).replace("0.", "").substring(0,6);
    }

    public void setConfirmation_number(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }
}

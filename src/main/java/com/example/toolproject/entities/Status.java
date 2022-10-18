package com.example.toolproject.entities;

public class Status {

    private int completedReservation;
    private int cancelledReservation;

    public Status(int completedReservation, int cancelledReservation) {
        this.completedReservation = completedReservation;
        this.cancelledReservation = cancelledReservation;
    }

    public int getCompletedReservation() {
        return completedReservation;
    }

    public void setCompletedReservation(int completedReservation) {
        this.completedReservation = completedReservation;
    }

    public int getCancelledReservation() {
        return cancelledReservation;
    }

    public void setCancelledReservation(int cancelledReservation) {
        this.cancelledReservation = cancelledReservation;
    }
}

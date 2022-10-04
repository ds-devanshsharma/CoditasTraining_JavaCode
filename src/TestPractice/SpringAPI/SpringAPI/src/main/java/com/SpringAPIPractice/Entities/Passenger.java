package com.SpringAPIPractice.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Passenger {

    @Id
    private int pID;
    private String passengerName;

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pID=" + pID +
                ", passengerName='" + passengerName + '\'' +
                '}';
    }
}
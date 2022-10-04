package com.SpringAPIPractice.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Car {
    @Id
    private int regNo;
    private String carName;
    private float carPrice;
    @OneToOne
    private Passenger passenger;
    @Override
    public String toString() {
        return "Car{" +
                "regNo=" + regNo +
                ", carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                ", passenger=" + passenger +
                '}';
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }



    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

}

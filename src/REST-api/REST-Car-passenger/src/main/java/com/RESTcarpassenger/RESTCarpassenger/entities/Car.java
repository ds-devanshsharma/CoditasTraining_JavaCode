package com.RESTcarpassenger.RESTCarpassenger.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String carName;
    @OneToMany(cascade = CascadeType.ALL)

    private List<Passenger> passengerList;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "Car[ " +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", passengerList=" + passengerList +" ]";
    }
}

package com.Springboot.CarPreBookingApplication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "car_store")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "carId")
    private Long carId ;

    @Column(name = "carModel" , nullable = false)
    private String carModel;

    @Column(name = "carPrice" ,nullable = false)
    private Double carPrice ;

    @Column(name = "carStatus" , nullable = false)
    private boolean carStatus;

    @OneToOne(mappedBy = "car")
    private CarBooking booking;
}

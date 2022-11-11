package com.Springboot.CarPreBookingApplication.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Customer_detail")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column(name = "customer_name" ,nullable = false)
    private String customerName;

    @Column(name="mobile_no" ,nullable = true)
    private String customerContact;

    @OneToMany(mappedBy = "customer")
    private List<CarBooking> carBookingList = new ArrayList<>();
}

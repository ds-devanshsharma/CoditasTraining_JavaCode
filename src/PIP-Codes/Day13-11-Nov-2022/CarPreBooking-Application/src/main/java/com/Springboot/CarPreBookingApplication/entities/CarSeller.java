package com.Springboot.CarPreBookingApplication.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CarSeller_detail")
public class CarSeller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sellerId;

    @Column(name = "SellerName")
    private String sellerName;

    @OneToOne(mappedBy = "carSeller")
    private Car sellingCar;

}

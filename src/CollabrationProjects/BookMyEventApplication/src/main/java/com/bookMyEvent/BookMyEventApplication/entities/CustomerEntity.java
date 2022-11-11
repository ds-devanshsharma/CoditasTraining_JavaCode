package com.bookMyEvent.BookMyEventApplication.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer_table")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String customerEmail;
    private Long contact;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<BookingEntity> bookingList =new ArrayList<>();
}

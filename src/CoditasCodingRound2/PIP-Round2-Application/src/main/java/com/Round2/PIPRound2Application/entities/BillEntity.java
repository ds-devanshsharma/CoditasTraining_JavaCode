package com.Round2.PIPRound2Application.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Bill_details")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billId;
    @Column(nullable = false)
    private double billAmount;
    @Column(nullable = false)
    private String billStatus;
    @OneToOne
    private BookingEntity booking;
}

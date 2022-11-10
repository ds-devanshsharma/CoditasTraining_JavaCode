package com.Round2.PIPRound2Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Booking_table")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private int reqSeat;

    @OneToOne
    @JoinColumn(name = "tableEntity")
    private TableEntity table;

    @OneToMany(mappedBy = "booking" )
    private List<OrderEntity> orders;
}

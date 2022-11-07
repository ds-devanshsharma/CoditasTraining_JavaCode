package com.Round2.PIPRound2Application.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Table_Booking_Details")
public class BookingDetails {
    @Id
    private int tableBookingId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int noOfSeatOfRequired;
    @OneToOne
    private TableStatus tableStatus;
}

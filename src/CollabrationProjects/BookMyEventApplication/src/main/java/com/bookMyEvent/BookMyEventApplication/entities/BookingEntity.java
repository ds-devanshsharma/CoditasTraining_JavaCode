package com.bookMyEvent.BookMyEventApplication.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
@Entity
@Table(name = "Booking_Table")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Date bookingStartDate;
    private Date bookingEndDate;
    private Time bookingStartTime;
    private Time bookingEndTime;
    private String bookingStatus;

    @ManyToOne
    private EventEntity event;

    @ManyToOne
    private CustomerEntity customer;
}

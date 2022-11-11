package com.bookMyEvent.BookMyEventApplication.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Event_table")
@Data
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @Column(nullable = false)
    private String eventName;
    private String eventVenue;
    private Double basePrice;

    @ManyToOne
    private EventOrganizerEntity eventOrganizer;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event")
    private List<BookingEntity> bookingList ;
}

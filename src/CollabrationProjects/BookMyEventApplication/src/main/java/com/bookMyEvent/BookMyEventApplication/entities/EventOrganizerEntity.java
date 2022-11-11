package com.bookMyEvent.BookMyEventApplication.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EventOrganizer_table")
@Data
public class EventOrganizerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventOrganizerId;
    private String eventOrganizerName;
    private String eventOrganizerEmail;
    private Long eventOrganizerContact;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "eventOrganizer")
    private List<EventEntity> eventList = new ArrayList<>();
}

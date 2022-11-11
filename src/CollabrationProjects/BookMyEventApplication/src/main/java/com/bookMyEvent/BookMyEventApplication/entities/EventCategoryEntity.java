package com.bookMyEvent.BookMyEventApplication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EventCategory_table")
@Data
public class EventCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventCategoryId;
    @Column(nullable = false
    )
    private String eventCategoryName;
}

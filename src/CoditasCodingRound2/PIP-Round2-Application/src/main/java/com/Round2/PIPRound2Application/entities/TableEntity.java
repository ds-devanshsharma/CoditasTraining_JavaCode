package com.Round2.PIPRound2Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Table_details")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tableId;
    @Column(nullable = false, name = "tableType")
    private int tableType ;
    @Column(nullable = false, name = "tableStatus")
    private String status;

    @OneToOne(mappedBy = "table")
    @JsonIgnore
    @JoinColumn(name = "bookingId")
    private BookingEntity booking;
}
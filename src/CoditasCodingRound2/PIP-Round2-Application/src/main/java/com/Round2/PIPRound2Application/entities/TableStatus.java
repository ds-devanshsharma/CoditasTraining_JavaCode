package com.Round2.PIPRound2Application.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Table_Status")
public class TableStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;
    private int  tableTypeId;
    @Column(nullable = false)
    private String tableStatus;
}

package com.Round2.PIPRound2Application.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Table_type")
public class TableType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableTypeId;
    @Column(nullable = false)
    private int tableId;
    @Column(nullable = false)
    private int countOfAvailableTable;
}

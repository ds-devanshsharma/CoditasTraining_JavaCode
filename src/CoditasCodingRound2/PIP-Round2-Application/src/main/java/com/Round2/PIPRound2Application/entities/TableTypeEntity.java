package com.Round2.PIPRound2Application.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Table_type_details")
public class TableType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableTypeId;
    @Column(nullable = false)
    private int tableType;
    @Column(nullable = false)
    private int countOfAvailableTable;
    @OneToMany(mappedBy = "tableType")
    private List<TableDetail> tableList;
}

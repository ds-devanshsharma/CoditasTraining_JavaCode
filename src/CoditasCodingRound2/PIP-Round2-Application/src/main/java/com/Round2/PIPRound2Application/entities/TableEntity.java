package com.Round2.PIPRound2Application.entities;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Table_details")
public class TableDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;
    @Column(nullable = false)
    private String status;

    @ManyToOne
    private TableType tableType;
}

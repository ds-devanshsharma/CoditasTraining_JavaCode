package com.Springboot.CodingRound3Application.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Player_table")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;

    @Column(nullable = false , unique = true ,
    name = "name")
    private String playerName;
}

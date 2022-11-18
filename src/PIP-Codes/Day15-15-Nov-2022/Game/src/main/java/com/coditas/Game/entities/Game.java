package com.coditas.Game.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Game_table")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String gameName;
    private boolean gameStatus;
}

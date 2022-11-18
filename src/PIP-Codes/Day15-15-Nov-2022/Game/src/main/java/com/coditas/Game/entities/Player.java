package com.coditas.Game.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Player_table")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;
    private String playerName;

    @ColumnDefault("false")
    private boolean playerStatus;
}

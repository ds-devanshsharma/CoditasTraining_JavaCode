package com.coditas.Game.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Player_Game")
public class PlayerGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gamePlayerSerialId;
    private Long playerId;
    private Long gameId;
    private Long positionX ;
    private Long positionY ;
    private Long hp;
    private boolean winner ;
    private LocalDate date;
}

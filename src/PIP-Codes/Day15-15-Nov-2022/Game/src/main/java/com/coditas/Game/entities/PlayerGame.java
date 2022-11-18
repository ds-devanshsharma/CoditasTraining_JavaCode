package com.coditas.Game.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("false")
    private boolean winner ;
    private LocalDate date;
}

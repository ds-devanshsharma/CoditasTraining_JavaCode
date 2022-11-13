package com.Springboot.CodingRound3Application.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name ="Game_Table")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;

    @Column(nullable = false , name = "date")
    private LocalDate date;

    @OneToOne
    private Player player1;

    @OneToOne
    private Player player2;

    @OneToOne
    @JoinColumn(name = "winnerPlayer")
    private Player winner;

}

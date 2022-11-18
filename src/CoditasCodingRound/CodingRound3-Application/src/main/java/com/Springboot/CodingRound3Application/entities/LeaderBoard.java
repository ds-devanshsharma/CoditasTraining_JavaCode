package com.Springboot.CodingRound3Application.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Leaderboard_table")
public class LeaderBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;

    @Column(name = "Points")
    private Long score ;
    @OneToOne
    private Game game ;

    @OneToOne
    private Player winner;
}

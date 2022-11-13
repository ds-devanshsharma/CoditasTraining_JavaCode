package com.Springboot.CodingRound3Application.repository;

import com.Springboot.CodingRound3Application.entities.Game;
import com.Springboot.CodingRound3Application.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}

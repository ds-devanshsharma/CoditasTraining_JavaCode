package com.Springboot.CodingRound3Application.repository;

import com.Springboot.CodingRound3Application.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player ,Long> {
}

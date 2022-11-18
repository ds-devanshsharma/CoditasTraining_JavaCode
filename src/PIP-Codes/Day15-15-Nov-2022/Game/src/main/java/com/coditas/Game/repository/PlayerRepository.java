package com.coditas.Game.repository;

import com.coditas.Game.entities.Game;
import com.coditas.Game.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
}

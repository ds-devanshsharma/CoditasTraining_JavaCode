package com.coditas.Game.repository;

import com.coditas.Game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
}

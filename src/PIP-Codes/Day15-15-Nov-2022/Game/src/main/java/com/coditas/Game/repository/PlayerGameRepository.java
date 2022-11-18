package com.coditas.Game.repository;
import com.coditas.Game.entities.PlayerGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlayerGameRepository extends JpaRepository<PlayerGame,Long> {
//    @Query(value = "SELECT * FROM PLAYER_GAME WHERE PLAYER_ID = ?1 AND GAME_ID =?2" ,nativeQuery = true)
//    PlayerGame findGameBasedOnGivenPlayerId(Long playerId , Long gameID);

//    @Query(value = "select * from PlayerGame where player_Id = ?1 and game_Id = ?2", nativeQuery = true)
//    Optional<PlayerGame> findByPlayerId(Long playerId, Long gameId);
//
    @Query(value = "SELECT * FROM player_game WHERE GAME_ID = ?1 AND WINNER = false" ,nativeQuery = true)
    List<PlayerGame> getListOfPlayerInGame(Long gameId);
 }

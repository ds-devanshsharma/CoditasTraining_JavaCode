package com.Springboot.CodingRound3Application.service;

import com.Springboot.CodingRound3Application.dto.request.AddPlayerDto;
import com.Springboot.CodingRound3Application.entities.Game;
import com.Springboot.CodingRound3Application.entities.Player;
import com.Springboot.CodingRound3Application.repository.GameRepository;
import com.Springboot.CodingRound3Application.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    PlayerRepository playerRepository ;

    @Autowired
    GameRepository gameRepository;
    @Override
    public Player registerPlayer(AddPlayerDto addPlayerDto) {
        Player createPlayer = new Player();
        createPlayer.setPlayerName(addPlayerDto.getPlayerName());
        return playerRepository.save(createPlayer);
    }

    @Override
    public int  createGame(Long playerId1, Long playerId2) {
        Player player1 = playerRepository.findById(playerId1).get();
        //player1 not found
        if(player1 == null) return 1;

        Player player2 = playerRepository.findById(playerId2).get();
        //player2 not found
        if(player2 == null) return 2;

        Game createGame = new Game();
        createGame.setPlayer1(player1);
        createGame.setPlayer2(player2);
        createGame.setDate(LocalDate.now());
        Game gameCreated = gameRepository.save(createGame);
        //game created Successfully
        if(gameCreated != null) return 3;

        //game not created
        return 0;
    }

    @Override
    public boolean startGame(Long gameId) {
        return false;
    }
}

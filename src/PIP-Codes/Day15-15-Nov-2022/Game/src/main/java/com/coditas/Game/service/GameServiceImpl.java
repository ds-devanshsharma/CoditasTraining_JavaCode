package com.coditas.Game.service;

import com.coditas.Game.entities.Game;
import com.coditas.Game.entities.Player;
import com.coditas.Game.entities.PlayerGame;
import com.coditas.Game.exception.GameAlreadyStartedException;
import com.coditas.Game.exception.GameNotFoundException;
import com.coditas.Game.exception.PlayerAlreadyInGameException;
import com.coditas.Game.exception.PlayerNotFoundException;
import com.coditas.Game.model.request.AddPlayerDto;
import com.coditas.Game.model.request.CreateGameDto;
import com.coditas.Game.model.request.StartGameDto;
import com.coditas.Game.repository.GameRepository;
import com.coditas.Game.repository.PlayerGameRepository;
import com.coditas.Game.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository ;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerGameRepository playerGameRepository;

    @Autowired
    ModelMapper mapper;
    @Override
    public Game createGame(CreateGameDto gameDto) {
        System.out.println(gameDto.getGameName());
        return gameRepository.save(this.mapper.map(gameDto , Game.class));
    }

    @Override
    public Player registerPlayer(AddPlayerDto addPlayer) {
        return playerRepository.save(this.mapper.map(addPlayer,Player.class));
    }

    @Override
    public String   startGame(StartGameDto startGameDto) {
        Player player1 = playerRepository.findById(startGameDto.getPlayerId1()).get();
        Player player2 = playerRepository.findById(startGameDto.getPlayerId2()).get();
        Game game = gameRepository.findById(startGameDto.getGameId()).get();
        if(player1 == null || player2 == null){
            throw new PlayerNotFoundException();
        }
        else if (player1.isPlayerStatus() || player2.isPlayerStatus()) {
            throw new PlayerAlreadyInGameException();
        }
        else if (game ==null) {
            throw new GameNotFoundException();
        }
        else if (game.isGameStatus()) {
            throw new GameAlreadyStartedException();
        } else {
            PlayerGame entry1 = new PlayerGame();
            //setting player1 details
            entry1.setGameId(startGameDto.getGameId());
            entry1.setDate(LocalDate.now());
            entry1.setPlayerId(startGameDto.getPlayerId1());
            Long number = ThreadLocalRandom.current().nextLong(-10, 9);
            entry1.setPositionX(number);
            entry1.setPositionY(number + 1);
            entry1.setHp(startGameDto.getHp());

            //player1 status busy
            player1.setPlayerStatus(true);

            //setting player2 details
            PlayerGame entry2 = new PlayerGame();
            entry2.setGameId(startGameDto.getGameId());
            entry2.setDate(LocalDate.now());
            entry2.setPlayerId(startGameDto.getPlayerId2());
            number = ThreadLocalRandom.current().nextLong(-10, 9);
            entry2.setPositionX(number-1);
            entry2.setPositionY(number);
            entry2.setHp(startGameDto.getHp());

            // setting player2 busy
            player2.setPlayerStatus(true);

            if(playerGameRepository.save(entry1)!=null && playerGameRepository.save(entry2) != null) {
                // setting game
                game.setGameStatus(true);
                gameRepository.save(game);
                return "Yes";
            }
        }
        return "No";
    }
}

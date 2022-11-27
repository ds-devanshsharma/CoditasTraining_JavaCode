package com.coditas.Game.controller;

import com.coditas.Game.entities.Game;
import com.coditas.Game.entities.Player;
import com.coditas.Game.model.request.AddPlayerDto;
import com.coditas.Game.model.request.CreateGameDto;
import com.coditas.Game.model.request.StartGameDto;
import com.coditas.Game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController{
    @Autowired
    GameService gameService;

    @PostMapping("/createGame")
    ResponseEntity createGameController(@RequestBody CreateGameDto createGameDto){
            Game gameCreated  = gameService.createGame(createGameDto);
            if(gameCreated != null)
                return new ResponseEntity("GAME CREATED !" ,HttpStatus.CREATED);
            else
                return new ResponseEntity("GAME NOT CREATED !",HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/registerPlayer")
    ResponseEntity registerPlayerController(@RequestBody AddPlayerDto addPlayer){
            Player addedPlayer = gameService.registerPlayer(addPlayer);
            if(addedPlayer != null)
                return new ResponseEntity(addedPlayer , HttpStatus.CREATED);
            else
                return new ResponseEntity("PLAYER NOT CREATED !",HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/startGame")
    ResponseEntity startGameController(@RequestBody StartGameDto startGameDto){
            String status = gameService.startGame(startGameDto);
            if(status == "Yes")
                return new ResponseEntity("GAME STARTED !" ,HttpStatus.CREATED);
            else
                return new ResponseEntity("GAME NOT STARTED !" ,HttpStatus.NOT_ACCEPTABLE);
    }
}

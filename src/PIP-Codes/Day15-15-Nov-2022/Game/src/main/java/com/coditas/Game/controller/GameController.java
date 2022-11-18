package com.coditas.Game.controller;

import com.coditas.Game.entities.Game;
import com.coditas.Game.model.request.CreateGameDto;
import com.coditas.Game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/createGame")
    ResponseEntity createGameController(CreateGameDto createGameDto){
        try{
            Game gameCreated  = gameService.createGame(createGameDto);
            if(gameCreated != null)
                return new ResponseEntity("GAME CREATED !" ,HttpStatus.CREATED);
            else
                return new ResponseEntity("GAME NOT CREATED !",HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

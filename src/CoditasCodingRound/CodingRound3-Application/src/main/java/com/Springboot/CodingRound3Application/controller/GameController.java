package com.Springboot.CodingRound3Application.controller;

import com.Springboot.CodingRound3Application.dto.request.AddPlayerDto;
import com.Springboot.CodingRound3Application.entities.Game;
import com.Springboot.CodingRound3Application.entities.Player;
import com.Springboot.CodingRound3Application.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService ;

    @PostMapping("/registerPlayer")
    ResponseEntity registerPlayerController(@RequestBody AddPlayerDto addPlayer){
        try{
            Player addedPlayer = gameService.registerPlayer(addPlayer);
            if(addedPlayer != null)
                return new ResponseEntity(addedPlayer , HttpStatus.CREATED);
            else
                return new ResponseEntity("PLAYER NOT CREATED !",HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/createGame/{playerId1}/{playerId2}")
    ResponseEntity createGameController(@PathVariable Long playerId1 , @PathVariable Long playerId2){
        try{
            int status = gameService.createGame(playerId1 , playerId2);
            if(status == 3)
                return new ResponseEntity("GAME CREATED !",HttpStatus.CREATED);
            else if(status == 1)
                return new ResponseEntity("PLAYER 1 NOT FOUND !" ,HttpStatus.NOT_FOUND);
            else if(status == 2)
                return new ResponseEntity("PLAYER 2 NOT FOUND !" ,HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity("GAME NOT CREATED ! SOMETHING WENT WRONG !" ,HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

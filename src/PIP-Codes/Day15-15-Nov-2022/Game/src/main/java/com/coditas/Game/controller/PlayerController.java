package com.coditas.Game.controller;

import com.coditas.Game.model.request.FireDto;
import com.coditas.Game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/forward/{gameId}/{playerId}")
    ResponseEntity moveForwardController(@PathVariable Long gameId ,@PathVariable Long playerId){
            Integer status = playerService.moveForward(gameId ,playerId);
            if (status == 1)
                return new ResponseEntity("MOVED ONE STEP FORWARD !", HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/backward/{gameId}/{playerId}")
    ResponseEntity moveBackwardController(@PathVariable Long gameId ,@PathVariable Long playerId){
            Integer newPosition = playerService.moveBackward(gameId ,playerId);
            if (newPosition ==1 )
                return new ResponseEntity("MOVED ONE STEP BACKWARD !", HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/upward/{gameId}/{playerId}")
    ResponseEntity moveUpwardController(@PathVariable Long gameId ,@PathVariable Long playerId){
            Integer newPosition = playerService.moveUpward(gameId ,playerId);
            if (newPosition ==1  )
                return new ResponseEntity("MOVED ONE STEP UPWARD !", HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/downward/{gameId}/{playerId}")
    ResponseEntity moveDownwardController(@PathVariable Long gameId ,@PathVariable Long playerId){
            Integer newPosition = playerService.moveDownward(gameId ,playerId);
            if (newPosition ==1 )
                return new ResponseEntity("MOVED ONE STEP DOWNWARD !", HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("fire/{gameId}/{playerId}")
    ResponseEntity fireWeaponController(@RequestBody FireDto fireDto ,@PathVariable Long gameId ,@PathVariable Long playerId)  {
            int status = playerService.fireWeapon(fireDto , gameId,playerId);
            if(status == 1)
                return new ResponseEntity("BULLET HIT !",HttpStatus.OK);
            else if(status == 22)
                return new ResponseEntity("GAME OVER ! PLAYER 1 WON !" , HttpStatus.OK);
            else if(status == 11 )
                return new ResponseEntity("GAME OVER ! PLAYER 1 WON !" ,HttpStatus.OK);
            else
                return new ResponseEntity("BULLET MISSED !" ,HttpStatus.NOT_ACCEPTABLE);
        }
    }



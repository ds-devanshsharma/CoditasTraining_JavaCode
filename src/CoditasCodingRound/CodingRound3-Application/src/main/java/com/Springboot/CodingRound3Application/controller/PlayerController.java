package com.Springboot.CodingRound3Application.controller;

import com.Springboot.CodingRound3Application.dto.request.FireDto;
import com.Springboot.CodingRound3Application.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/forward/{player}")
    ResponseEntity moveForwardController(@PathVariable int playerNumber){
        try {
            HashMap newPosition = playerService.moveForward(playerNumber);
            if (newPosition !=null )
                return new ResponseEntity(newPosition, HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/backward/{playerNumber}")
    ResponseEntity moveBackwardController(@PathVariable int playerNumber){
        try {
            HashMap newPosition = playerService.moveBackward(1);
            if (newPosition !=null )
                return new ResponseEntity(newPosition, HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/upward/{playerNumber}")
    ResponseEntity moveUpwardController(@PathVariable int playerNumber){
        try {
            HashMap newPosition = playerService.moveUpward(playerNumber);
            if (newPosition !=null )
                return new ResponseEntity(newPosition, HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/downward/{playerNumber}")
    ResponseEntity moveDownwardController(@PathVariable int playerNumber){
        try {
            HashMap newPosition = playerService.moveDownward(playerNumber);
            if (newPosition !=null )
                return new ResponseEntity(newPosition, HttpStatus.OK);
            else
                return new ResponseEntity("POSITION OVERLAPPED !" ,HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("fire/{playerNumber}")
    ResponseEntity fireWeaponController(@RequestBody FireDto fireDto ,@PathVariable int playerNumber)  {
        try{
            int status = playerService.fireWeapon(fireDto , playerNumber);
            if(status == 1)
                return new ResponseEntity("BULLET HIT !",HttpStatus.OK);
            else if(status == 22)
                return new ResponseEntity("GAME OVER ! PLAYER 1 WON !" , HttpStatus.OK);
            else if(status == 11 )
                return new ResponseEntity("GAME OVER ! PLAYER 1 WON !" ,HttpStatus.OK);
            else
                return new ResponseEntity("BULLET MISSED !" ,HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.coditas.Game.exception;

public class PlayerAlreadyInGameException extends RuntimeException{
    public PlayerAlreadyInGameException(){
        super("PLAYER ALREADY IN GAME !");
    }
}

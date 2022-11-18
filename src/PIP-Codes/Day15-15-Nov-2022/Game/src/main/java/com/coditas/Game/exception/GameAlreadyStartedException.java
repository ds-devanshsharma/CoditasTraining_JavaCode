package com.coditas.Game.exception;

public class GameAlreadyStartedException extends RuntimeException{
    public GameAlreadyStartedException(){
        super("GAME ALREADY IN PROGRESS !");
    }
}

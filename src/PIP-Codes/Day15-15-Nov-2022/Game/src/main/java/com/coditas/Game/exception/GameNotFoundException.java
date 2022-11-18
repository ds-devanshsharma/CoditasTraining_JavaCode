package com.coditas.Game.exception;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException(){
        super("GAME NOT FOUND !");
    }
}

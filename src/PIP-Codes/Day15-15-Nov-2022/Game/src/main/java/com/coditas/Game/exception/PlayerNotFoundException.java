package com.coditas.Game.exception;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(){
        super("PLAYER NOT FOUND !");
    }
}

package com.coditas.Game.exception;

public class OutOfBoundaryException extends RuntimeException{
    public OutOfBoundaryException(){
        super("OUT OF BOUNDARY ,YOU CANT MOVE !");
    }
}

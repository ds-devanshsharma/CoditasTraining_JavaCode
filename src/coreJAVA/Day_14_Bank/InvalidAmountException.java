package coreJAVA.Day_14_Bank;

class InvalidAmountException extends Exception{
    InvalidAmountException(int amount){
        System.out.println("You have entered InvalidAmount !! :: "+ amount );
    }
}
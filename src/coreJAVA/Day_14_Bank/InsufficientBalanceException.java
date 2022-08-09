package coreJAVA.Day_14_Bank;

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(){
        System.out.println(Bank.balance+" :: Insufficient balance !!! ");
    }
}
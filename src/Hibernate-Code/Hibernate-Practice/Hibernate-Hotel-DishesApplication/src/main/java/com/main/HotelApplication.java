package com.main;


public class HotelApplication {
    public static void main(String[] args) {
       try{
           new Menu().menu();
       }catch (Exception e ){
           System.out.println(e.getMessage());
       }
    }
}

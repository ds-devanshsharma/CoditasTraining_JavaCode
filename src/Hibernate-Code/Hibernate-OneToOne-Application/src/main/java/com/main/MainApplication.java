package com.main;
public class MainApplication {
    public static void main(String[] args) {

       try{
           new Menu().menu();
       }catch (Exception e ){
           e.printStackTrace();
       }

    }
}

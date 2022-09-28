package com.main;
public class MainApplication {
    public static void main(String[] args) {

        try{
            System.out.println("<-- BOOK SYSTEM -->");
            new Menu().menu();
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
}

package com.Springboot.CodingRound3Application.service;

import com.Springboot.CodingRound3Application.dto.request.FireDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlayerServiceImpl implements PlayerService{
    static int player1Hp = 100 ;
    static int player2Hp = 100 ;
    static int player1_x = 0;
    static int player1_y = 0;

    static int player2_x =1;
    static int player2_y =1;

    boolean checkOverlapping(int x1 ,int x2, int y1 ,int y2) {
        if(x1==x2 && y1==y2)return true;

        else return false;
    }

    @Override
    public HashMap moveForward(int playerNumber) {
        if(checkOverlapping(player1_x,player2_x,player1_y,player2_y)) return null;
        else{
            if(playerNumber ==1 ){
                player1_x +=1;
                return new HashMap(player1_x ,player1_y);
            }
            else{
                player2_x +=1;
                return new HashMap(player2_x , player2_y);
            }

        }
    }

    @Override
    public HashMap moveBackward(int playerNumber) {
        if(checkOverlapping(player1_x,player2_x,player1_y,player2_y)) return null;
        else{
            if(playerNumber ==1 ){
                player1_x -=1;
                return new HashMap(player1_x ,player1_y);
            }
            else{
                player2_x -=1;
                return new HashMap(player2_x , player2_y);
            }

        }
    }

    @Override
    public HashMap moveUpward(int playerNumber) {
        if(checkOverlapping(player1_x,player2_x,player1_y,player2_y)) return null;
        else{
            if(playerNumber ==1 ){
                player1_y +=1;
                return new HashMap(player1_x ,player1_y);
            }
            else{
                player2_y +=1;
                return new HashMap(player2_x , player2_y);
            }
        }
    }

    @Override
    public HashMap moveDownward(int playerNumber) {
        if(checkOverlapping(player1_x,player2_x,player1_y,player2_y)) return null;
        else{
            if(playerNumber ==1 ){
                player1_y -=1;
                return new HashMap(player1_x ,player1_y);
            }
            else{
                player2_y -=1;
                return new HashMap(player2_x , player2_y);
            }
        }
    }

    @Override
    public int

    fireWeapon(FireDto fireDto ,int playerNumber) {
        if(playerNumber ==1 ){
            if(fireDto.getX()==player2_x && fireDto.getY()==player2_y){
                // returning 11 means player 1 won
                if(player2Hp <=0 ) return 11;
                player2Hp -=20;
                //returning 1 means bullet Hit
                return 1;
            }
            // returning -1 means bullet missed target
            else return -1;
        }
        else{
            if(fireDto.getX()==player1_x && fireDto.getY()==player1_y){
                // returning 22 means player 2 won
                if(player1Hp <= 0 )return 22;
                player1Hp -=20;
                return 1;
            }
            else return -1;
        }
    }
}

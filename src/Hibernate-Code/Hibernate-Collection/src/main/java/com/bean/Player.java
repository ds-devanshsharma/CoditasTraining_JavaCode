package com.bean;

public class Player {
    private int playerID ;
    private String playerName ;
    private float bidValue ;

    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", bidValue=" + bidValue +
                '}';
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public float getBidValue() {
        return bidValue;
    }

    public void setBidValue(float bidValue) {
        this.bidValue = bidValue;
    }

    public Player(int playerID, String playerName, float bidValue) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.bidValue = bidValue;
    }
}

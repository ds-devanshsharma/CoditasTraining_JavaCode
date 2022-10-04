package com.bean;

import java.util.Map;

public class IPLTeam {
    private int teamID;
    private String teamName , ownerName;
    private Map<String,Player> playerMap;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<String, Player> playerMap) {
        this.playerMap = playerMap;
    }


    @Override
    public String toString() {
        return "IPLTeam{" +
                "teamID=" + teamID +
                ", teamName='" + teamName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", playerMap=" + playerMap +
                '}';
    }
}

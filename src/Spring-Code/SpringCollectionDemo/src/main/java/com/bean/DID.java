package com.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DID {
    private String seasons;
    private List<String> brandPartners;
    @Autowired
    private Map<Participants,String> participants;

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public List<String> getBrandPartners() {
        return brandPartners;
    }

    public void setBrandPartners(List<String> brandPartners) {
        this.brandPartners = brandPartners;
    }

    public Map<Participants, String> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<Participants, String> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "DID{" +
                "seasons='" + seasons + '\'' +
                ", brandPartners=" + brandPartners +
                ", participants=" + participants +
                '}';
    }
}

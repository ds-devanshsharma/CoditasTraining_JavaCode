package com.Springboot.Voting.Application.dto.response;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class PartyResultDto {
    private Long partyId;
    private String partyName;
    private String partySymbol;
    private Long countOfVotes;
}

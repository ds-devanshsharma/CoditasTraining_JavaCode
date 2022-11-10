package com.Springboot.Voting.Application.dto.request;

import lombok.Data;

@Data
public class PartyRegisterDto {
    private String partyName;
    private String partySymbol;
    private String partySlogan;
}

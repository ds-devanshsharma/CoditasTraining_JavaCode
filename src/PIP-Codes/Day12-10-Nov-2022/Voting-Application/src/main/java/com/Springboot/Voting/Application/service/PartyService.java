package com.Springboot.Voting.Application.service;

import com.Springboot.Voting.Application.dto.request.PartyRegisterDto;
import com.Springboot.Voting.Application.dto.response.PartyResultDto;
import com.Springboot.Voting.Application.entities.Party;


public interface PartyService {
    Party registerParty(PartyRegisterDto Party);
    PartyResultDto countOfVotes(Long partyId);
}

package com.Springboot.Voting.Application.service;

import com.Springboot.Voting.Application.dto.request.PartyRegisterDto;
import com.Springboot.Voting.Application.dto.response.PartyResultDto;
import com.Springboot.Voting.Application.entities.Party;
import com.Springboot.Voting.Application.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService{
    @Autowired
    PartyRepository partyRepository;
    @Override
    public Party registerParty(PartyRegisterDto partyDto) {
        if(!(partyRepository.getByPartyName(partyDto.getPartyName()).size()>0 &&
        partyRepository.getByPartySymbol(partyDto.getPartySymbol()).size()>0)){
            Party registerParty = new Party();
            registerParty.setPartyName(partyDto.getPartyName());
            registerParty.setPartySymbol(partyDto.getPartySymbol());
            registerParty.setPartySlogan(partyDto.getPartySlogan());
            return partyRepository.save(registerParty);
        }
        return null;
    }

    @Override
    public PartyResultDto countOfVotes(Long partyId) {
        Party party = partyRepository.findById(partyId).get();
        if(party != null){
            PartyResultDto result = new PartyResultDto();
            result.setPartyId(party.getPartyId());
            result.setPartyName(party.getPartyName());
            result.setPartySymbol(party.getPartySymbol());
            result.setCountOfVotes((long)party.getVoterList().size());
            return result;
        }
        return null;
    }
}

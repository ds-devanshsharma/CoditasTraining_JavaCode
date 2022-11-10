package com.Springboot.Voting.Application.controller;


import com.Springboot.Voting.Application.dto.request.PartyRegisterDto;
import com.Springboot.Voting.Application.entities.Party;
import com.Springboot.Voting.Application.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    PartyService PartyService;

    @PostMapping("/registerParty")
    public ResponseEntity registerPartyController(@RequestBody  PartyRegisterDto PartyDto){
        try{
//            HashMap<String,String> map = new HashMap<>();
            Party registerParty = PartyService.registerParty(PartyDto);
            if(registerParty !=null )
                return new ResponseEntity(registerParty, HttpStatus.CREATED);
            else
                return new ResponseEntity("Party Not Registered !May be Your partyName OR Your partySymbol not Unique! ",HttpStatus.NOT_ACCEPTABLE);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

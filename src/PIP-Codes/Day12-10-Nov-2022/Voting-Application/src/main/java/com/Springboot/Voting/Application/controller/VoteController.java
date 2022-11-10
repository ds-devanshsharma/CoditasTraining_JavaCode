package com.Springboot.Voting.Application.controller;

import com.Springboot.Voting.Application.dto.request.VoteDto;
import com.Springboot.Voting.Application.dto.response.PartyResultDto;
import com.Springboot.Voting.Application.service.PartyService;
import com.Springboot.Voting.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    UserService userService;

    @Autowired
    PartyService partyService;

    @PatchMapping("/addVote")
    ResponseEntity addVoteController(@RequestBody  VoteDto voteDto){
        try {
            if (userService.giveVote(voteDto)) {
                return new ResponseEntity("Vote Added Successfully !!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity("Your Vote Not Added ,You have already given vote !!", HttpStatus.NOT_ACCEPTABLE);
            }
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/viewCountOfVotes/{partyId}")
    ResponseEntity countVotesOfPartyController(@PathVariable Long partyId){
        try{
            PartyResultDto resultDto = null ;
            resultDto = partyService.countOfVotes(partyId);
            if(resultDto != null)
                return new ResponseEntity(resultDto,HttpStatus.FOUND);
            else
                return new ResponseEntity("Failed to get Your result !!",HttpStatus.NOT_FOUND);
        }
        catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity("PARTY NOT FOUND !!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

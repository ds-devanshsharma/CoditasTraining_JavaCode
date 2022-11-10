package com.Springboot.Voting.Application.service;

import com.Springboot.Voting.Application.dto.request.UserRegisterDto;
import com.Springboot.Voting.Application.dto.request.VoteDto;
import com.Springboot.Voting.Application.entities.Party;
import com.Springboot.Voting.Application.entities.User;
import com.Springboot.Voting.Application.repository.PartyRepository;
import com.Springboot.Voting.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PartyRepository partyRepository;
    @Override
    public User registerUser(UserRegisterDto userDto) {
        if(userDto.getAge() > 18) {

            User registeredUser = new User();
            registeredUser.setUserId((long)(Math.random() * 100000000));
            registeredUser.setUserContact(userDto.getContact());
            registeredUser.setUserAge(userDto.getAge());
            registeredUser.setUserName(userDto.getUsername());
            registeredUser.setUserPassword(userDto.getPassword());
            return userRepository.save(registeredUser);
        }
        return null;
    }

    @Override
    public boolean giveVote(VoteDto voteDto) {
        Party party = partyRepository.findById(voteDto.getPartyId()).get();
        User user = userRepository.findById(voteDto.getUserId()).get();
        if((user !=null && party!=null )&& user.isVoteGiven()==false){
            party.getVoterList().add(user);
            user.setVoteGiven(true);
            user.setParty(party);
            partyRepository.save(party);
            return true;
        }
        return false;
    }

}

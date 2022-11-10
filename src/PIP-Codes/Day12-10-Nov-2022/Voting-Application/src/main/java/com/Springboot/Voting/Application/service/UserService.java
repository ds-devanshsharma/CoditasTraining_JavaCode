package com.Springboot.Voting.Application.service;

import com.Springboot.Voting.Application.dto.request.UserRegisterDto;
import com.Springboot.Voting.Application.dto.request.VoteDto;
import com.Springboot.Voting.Application.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserRegisterDto user);
    boolean giveVote(VoteDto voteDto);
}

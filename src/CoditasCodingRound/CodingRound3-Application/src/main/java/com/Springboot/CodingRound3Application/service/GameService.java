package com.Springboot.CodingRound3Application.service;

import com.Springboot.CodingRound3Application.dto.request.AddPlayerDto;
import com.Springboot.CodingRound3Application.entities.Game;
import com.Springboot.CodingRound3Application.entities.Player;

public interface GameService {
    Player registerPlayer(AddPlayerDto addPlayerDto);

    int createGame(Long playerId1, Long playerId2);
}

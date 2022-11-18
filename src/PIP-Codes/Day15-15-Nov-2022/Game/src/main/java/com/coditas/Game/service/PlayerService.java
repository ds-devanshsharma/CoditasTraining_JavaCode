package com.coditas.Game.service;

import com.coditas.Game.model.request.FireDto;

import java.util.HashMap;

public interface PlayerService {
    Integer moveForward(Long gameId ,Long playerId);
    Integer moveBackward(Long gameId ,Long playerId);
    Integer moveUpward(Long gameId ,Long playerId);
    Integer moveDownward(Long gameId ,Long playerId);
    int fireWeapon(FireDto fireDto , Long gameId , Long playerId);
}

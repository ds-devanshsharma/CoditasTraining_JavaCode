package com.Springboot.CodingRound3Application.service;

import com.Springboot.CodingRound3Application.dto.request.FireDto;

import java.util.HashMap;

public interface PlayerService {
    HashMap moveForward(int playerNumber);
    HashMap moveBackward(int playerNumber);
    HashMap moveUpward(int playerNumber);
    HashMap moveDownward(int playerNumber);
    int fireWeapon(FireDto fireDto ,int playerNumber);
}

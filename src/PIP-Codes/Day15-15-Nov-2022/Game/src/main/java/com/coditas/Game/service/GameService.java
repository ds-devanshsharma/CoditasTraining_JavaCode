package com.coditas.Game.service;

import com.coditas.Game.entities.Game;
import com.coditas.Game.model.request.CreateGameDto;

public interface GameService {
    Game createGame(CreateGameDto gameDto);
}

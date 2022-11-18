package com.coditas.Game.service;

import com.coditas.Game.entities.Game;
import com.coditas.Game.entities.Player;
import com.coditas.Game.entities.PlayerGame;
import com.coditas.Game.model.request.AddPlayerDto;
import com.coditas.Game.model.request.CreateGameDto;
import com.coditas.Game.model.request.StartGameDto;

public interface GameService {
    Game createGame(CreateGameDto gameDto);
    Player registerPlayer(AddPlayerDto addPlayer);
    String  startGame(StartGameDto startGameDto);
}

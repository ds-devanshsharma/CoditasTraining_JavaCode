package com.coditas.Game.service;
import com.coditas.Game.entities.PlayerGame;
import com.coditas.Game.exception.GameNotFoundException;
import com.coditas.Game.exception.OutOfBoundaryException;
import com.coditas.Game.exception.PlayerIsNotInThatGameException;
import com.coditas.Game.exception.PositionOverlappedException;
import com.coditas.Game.model.request.FireDto;
import com.coditas.Game.repository.GameRepository;
import com.coditas.Game.repository.PlayerGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    GameRepository gameRepository ;
    @Autowired
    PlayerGameRepository playerGameRepository;

    boolean checkOverlapping(Long x1 ,Long x2, Long y1 ,Long y2) {
        if(x1==x2 && y1==y2)return true;
        else return false;
    }

    @Override
    public Integer moveForward(Long gameId, Long playerId) {
//        PlayerGame gamePlayer1 = playerGameRepository.findGameBasedOnGivenPlayerId(playerId,gameId);
        List<PlayerGame> playerIdListInGame = playerGameRepository.getListOfPlayerInGame(gameId);
        if(playerIdListInGame.isEmpty())
            throw new GameNotFoundException();
        List<PlayerGame> gamePlayer1List = playerIdListInGame.stream().filter(item -> item.getPlayerId() == playerId)
                .collect(Collectors.toList());
        if(gamePlayer1List.isEmpty()) throw new PlayerIsNotInThatGameException();
        PlayerGame gamePlayer1 = gamePlayer1List.get(0);
        PlayerGame gamePlayer2 = playerIdListInGame.stream().filter(item -> item.getPlayerId() != playerId)
                .collect(Collectors.toList()).get(0);
        if(gamePlayer1 == null)
            throw new PlayerIsNotInThatGameException();
        else if(checkOverlapping(gamePlayer1.getPositionX(),gamePlayer2.getPositionX()
                ,gamePlayer1.getPositionY(),gamePlayer2.getPositionY())){
            throw new PositionOverlappedException();
        }
        else{
            if(gamePlayer1.getPositionX()+1 > 10 )
                throw new OutOfBoundaryException();
            gamePlayer1.setPositionX(gamePlayer1.getPositionX()+1);
            playerGameRepository.save(gamePlayer1);
            return 1;
        }
    }

    @Override
    public Integer moveBackward(Long gameId, Long playerId) {
        List<PlayerGame> playerIdListInGame = playerGameRepository.getListOfPlayerInGame(gameId);
        if(playerIdListInGame.isEmpty())
            throw new GameNotFoundException();
        List<PlayerGame> gamePlayer1List = playerIdListInGame.stream().filter(item -> item.getPlayerId() == playerId)
                .collect(Collectors.toList());
        if(gamePlayer1List.isEmpty()) throw new PlayerIsNotInThatGameException();
        PlayerGame gamePlayer1 = gamePlayer1List.get(0);
        PlayerGame gamePlayer2 = playerIdListInGame.stream().filter(item -> item.getPlayerId() != playerId)
                .collect(Collectors.toList()).get(0);
        if(gamePlayer1 == null)
            throw new PlayerIsNotInThatGameException();
        else if(checkOverlapping(gamePlayer1.getPositionX(),gamePlayer2.getPositionX()
                ,gamePlayer1.getPositionY(),gamePlayer2.getPositionY())){
            throw new PositionOverlappedException();
        }
        else{
            if(gamePlayer1.getPositionX()-1 < -10 )
                throw new OutOfBoundaryException();
            gamePlayer1.setPositionX(gamePlayer1.getPositionX()-1);
            playerGameRepository.save(gamePlayer1);
            return 1;
        }
    }

    @Override
    public Integer moveUpward(Long gameId, Long playerId) {
        List<PlayerGame> playerIdListInGame = playerGameRepository.getListOfPlayerInGame(gameId);
        if(playerIdListInGame.isEmpty())
            throw new GameNotFoundException();
        List<PlayerGame> gamePlayer1List = playerIdListInGame.stream().filter(item -> item.getPlayerId() == playerId)
                .collect(Collectors.toList());
        if(gamePlayer1List.isEmpty()) throw new PlayerIsNotInThatGameException();
        PlayerGame gamePlayer1 = gamePlayer1List.get(0);
        PlayerGame gamePlayer2 = playerIdListInGame.stream().filter(item -> item.getPlayerId() != playerId)
                .collect(Collectors.toList()).get(0);
        if(gamePlayer1 == null)
            throw new PlayerIsNotInThatGameException();
        else if(checkOverlapping(gamePlayer1.getPositionX(),gamePlayer2.getPositionX()
                ,gamePlayer1.getPositionY(),gamePlayer2.getPositionY())){
            throw new PositionOverlappedException();
        }
        else{
            if(gamePlayer1.getPositionY()+1 > 10 )
                throw new OutOfBoundaryException();
            gamePlayer1.setPositionY(gamePlayer1.getPositionY()+1);
            playerGameRepository.save(gamePlayer1);
            return 1;
        }
    }

    @Override
    public Integer moveDownward(Long gameId, Long playerId) {
        List<PlayerGame> playerIdListInGame = playerGameRepository.getListOfPlayerInGame(gameId);
        if(playerIdListInGame.isEmpty())
            throw new GameNotFoundException();
        List<PlayerGame> gamePlayer1List = playerIdListInGame.stream().filter(item -> item.getPlayerId() == playerId)
                .collect(Collectors.toList());
        if(gamePlayer1List.isEmpty()) throw new PlayerIsNotInThatGameException();
        PlayerGame gamePlayer1 = gamePlayer1List.get(0);
        PlayerGame gamePlayer2 = playerIdListInGame.stream().filter(item -> item.getPlayerId() != playerId)
                .collect(Collectors.toList()).get(0);
        if(gamePlayer1 == null)
            throw new PlayerIsNotInThatGameException();
        else if(checkOverlapping(gamePlayer1.getPositionX(),gamePlayer2.getPositionX()
                ,gamePlayer1.getPositionY(),gamePlayer2.getPositionY())){
            throw new PositionOverlappedException();
        }
        else{
            if(gamePlayer1.getPositionY()-1 < -10 )
                throw new OutOfBoundaryException();
            gamePlayer1.setPositionY(gamePlayer1.getPositionY()-1);
            playerGameRepository.save(gamePlayer1);
            return 1;
        }
    }

    @Override
    public int fireWeapon(FireDto fireDto, Long gameId, Long playerId) {
        List<PlayerGame> playerIdListInGame = playerGameRepository.getListOfPlayerInGame(gameId);
        if(playerIdListInGame.isEmpty())
            throw new GameNotFoundException();
        List<PlayerGame> gamePlayer1List = playerIdListInGame.stream().filter(item -> item.getPlayerId() == playerId)
                .collect(Collectors.toList());
        if(gamePlayer1List.isEmpty()) throw new PlayerIsNotInThatGameException();
        PlayerGame gamePlayer1 = gamePlayer1List.get(0);
        PlayerGame gamePlayer2 = playerIdListInGame.stream().filter(item -> item.getPlayerId() != playerId)
                .collect(Collectors.toList()).get(0);

        // bullet hit logic
        if(gamePlayer2.getHp() <= 0 ){
            gamePlayer1.setWinner(true);
            playerGameRepository.save(gamePlayer1);
            return  11 ;
        }
        if(fireDto.getX() == gamePlayer2.getPositionX() && fireDto.getY() == gamePlayer2.getPositionY()){
            gamePlayer2.setHp(gamePlayer2.getHp()-20);
            playerGameRepository.save(gamePlayer2);
            return 1 ;
        }
        return 0;
    }
}

package com.coditas.Game.model.request;

import lombok.Data;

@Data
public class StartGameDto {
    private Long hp =100l ;
    private Long gameId;
    private Long playerId1 ;
    private Long playerId2 ;
}

package com.boardgame.dto;

import lombok.Data;

@Data
public class GameDto {

    private Integer id;

    private String creationDate;

    private String name;

    private Integer maxNbPlayers;

    private Integer minNbPlayers;

    private Integer averageTimePlayed;
}

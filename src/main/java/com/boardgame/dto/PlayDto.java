package com.boardgame.dto;

import com.boardgame.model.Game;
import com.boardgame.model.Player;
import lombok.Data;

import java.sql.Date;

@Data
public class PlayDto {

    private Integer id;

    private String creationDate;

    private Date gameDate;

    private int score;

    private Player player;

    private Game game;
}

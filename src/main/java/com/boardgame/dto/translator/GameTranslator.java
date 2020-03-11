package com.boardgame.dto.translator;

import com.boardgame.dto.GameDto;
import com.boardgame.model.Game;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GameTranslator {

    public GameDto translateGameToGameDto(Game game) {
        GameDto gameDto = new GameDto();
        gameDto.setName(game.getName());
        gameDto.setId(game.getId());
        gameDto.setAverageTimePlayed(game.getAverageTimePlayed());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        gameDto.setCreationDate(df.format(game.getCreationDate()));

        gameDto.setMaxNbPlayers(game.getMaxNbPlayers());
        gameDto.setMinNbPlayers(game.getMinNbPlayers());

        return gameDto;
    }

    public Game translateGameDtoToGame(GameDto gameDto) {
        Game game = new Game();
        game.setName(gameDto.getName());
        game.setId(gameDto.getId());
        game.setAverageTimePlayed(gameDto.getAverageTimePlayed());
        game.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
        game.setMaxNbPlayers(gameDto.getMaxNbPlayers());
        game.setMinNbPlayers(gameDto.getMinNbPlayers());

        return game;
    }
}

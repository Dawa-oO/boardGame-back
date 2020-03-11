package com.boardgame.dto.translator;

import com.boardgame.dto.PlayDto;
import com.boardgame.model.Play;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PlayTranslator {
    public PlayDto translatePlayToPlayDto(Play play) {
        PlayDto playDto = new PlayDto();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        playDto.setCreationDate(df.format(play.getCreationDate()));
        playDto.setId(play.getId());
        playDto.setGameDate(play.getGameDate());
        playDto.setScore(play.getScore());
        playDto.setGame(play.getGame());
        playDto.setPlayer(play.getPlayer());

        return playDto;
    }

    public Play translatePlayDtoToPlay(PlayDto playDto) {
        Play play = new Play();

        play.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
        play.setId(playDto.getId());
        play.setGameDate(playDto.getGameDate());
        play.setScore(playDto.getScore());
        play.setGame(playDto.getGame());
        play.setPlayer(playDto.getPlayer());

        return play;
    }
}

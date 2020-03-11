package com.boardgame.dto.translator;

import com.boardgame.dto.PlayerDto;
import com.boardgame.model.Player;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PlayerTranslator {
    public PlayerDto translatePlayerToPlayerDto(Player player) {
        PlayerDto playerDto = new PlayerDto();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        playerDto.setCreationDate(df.format(player.getCreationDate()));
        playerDto.setId(player.getId());
        playerDto.setFirstName(player.getFirstName());
        playerDto.setPseudo(player.getPseudo());

        return playerDto;
    }

    public Player translatePlayerDtoToPlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
        player.setId(playerDto.getId());
        player.setFirstName(playerDto.getFirstName());
        player.setPseudo(playerDto.getPseudo());

        return player;
    }
}

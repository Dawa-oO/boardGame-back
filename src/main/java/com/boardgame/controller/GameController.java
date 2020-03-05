package com.boardgame.controller;

import com.boardgame.dto.GameDto;
import com.boardgame.model.Game;
import com.boardgame.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;


@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping

    public @ResponseBody String addNewGame (@RequestBody GameDto gameDto) {

        System.out.println(gameDto.toString());

        Game game=new Game();

        game.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
        game.setName(gameDto.getName());
        game.setMaxNbPlayers(gameDto.getMaxNbPlayers());
        game.setMinNbPlayers(gameDto.getMinNbPlayers());
        game.setAverageTimePlayed(gameDto.getAverageTimePlayed());

        gameRepository.save(game);
        return "Saved";
    }


}

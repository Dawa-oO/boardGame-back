package com.boardgame.controller;

import com.boardgame.dto.GameDto;
import com.boardgame.dto.translator.GameTranslator;
import com.boardgame.model.Game;
import com.boardgame.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    private GameTranslator translator = new GameTranslator();

    @PostMapping
    public @ResponseBody String addNewGame(@RequestBody GameDto gameDto) {
        System.out.println(gameDto.toString());
        gameRepository.save(translator.translateGameDtoToGame(gameDto));
        return "Saved";
    }

    @GetMapping
    public @ResponseBody List<GameDto> getAllGames() {
//        List<Game> listGamesDb = (List<Game>) gameRepository.findAll();
//
//        List<GameDto> list = new ArrayList<>();
//        for(Game game : listGamesDb) {
//            GameDto dto = translator.translateGameToGameDto(game);
//            list.add(dto);
//        }
//

        // This returns a JSON or XML with the users
        return StreamSupport.stream(gameRepository.findAll().spliterator(), false).map(translator::translateGameToGameDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody GameDto getGameById(@PathVariable int id){
        return gameRepository.findById(id).map(translator::translateGameToGameDto).orElse(null);
    }


}

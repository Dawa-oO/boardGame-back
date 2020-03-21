package com.boardgame.controller;

import com.boardgame.dto.PlayDto;
import com.boardgame.dto.TopPlayerByGameDto;
import com.boardgame.dto.translator.PlayTranslator;
import com.boardgame.model.Game;
import com.boardgame.model.Play;
import com.boardgame.model.Player;
import com.boardgame.model.TopPlayerByGame;
import com.boardgame.repositories.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/plays")
public class PlayController {
    @Autowired
    private PlayRepository playRepository;
    private PlayTranslator translator = new PlayTranslator();

    @PostMapping
    public @ResponseBody String addNewPlay(@RequestBody PlayDto playDto) {
        playRepository.save(translator.translatePlayDtoToPlay(playDto));
        return "Saved";
    }

    @GetMapping
    public @ResponseBody List<PlayDto> getAllPlays() {
        return StreamSupport.stream(playRepository.findAll().spliterator(), false).map(translator::translatePlayToPlayDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody PlayDto getPlayById(@PathVariable int id) {
        return playRepository.findById(id).map(translator::translatePlayToPlayDto).orElse(null);
    }

    @GetMapping(value="/total")
    public @ResponseBody long getNumberPlays(){
        return playRepository.count();
    }

    @GetMapping(value="/total/players/{player}")
    public @ResponseBody long getNumberPlaysByWinnerId(@PathVariable Player player){
        return playRepository.countPlayByPlayer(player);
    }

    @GetMapping(value="/total/{game}")
    public @ResponseBody long getNumberPlaysByGameId(@PathVariable Game game){
        return playRepository.countPlayByGame(game);
    }

    @GetMapping("/topPlayer/{gameId}")
    public @ResponseBody TopPlayerByGameDto getTopPlayerByGameId(@PathVariable int gameId) {
        TopPlayerByGame topPlayerByGame =  playRepository.getTopPlayerByGameId(gameId);

        if(topPlayerByGame != null) {
            // Build the response
            TopPlayerByGameDto topPlayerByGameDto = new TopPlayerByGameDto();
            topPlayerByGameDto.setWinnerId(topPlayerByGame.getWinnerId());
            topPlayerByGameDto.setNbVictory(topPlayerByGame.getNbVictory());

            return topPlayerByGameDto;
        }

        return null;
    }

    @GetMapping("/topScore/{gameId}")
    public @ResponseBody long getTopScoreByGameId(@PathVariable Game gameId){
        Play play = playRepository.findFirstByGameOrderByScoreDesc(gameId);
        return (play!=null)? play.getScore(): 0;
    }
}

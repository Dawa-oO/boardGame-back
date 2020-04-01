package com.boardgame.controller;

import com.boardgame.dto.PlayDto;
import com.boardgame.dto.TopPlayerByGameDto;
import com.boardgame.dto.translator.PlayTranslator;
import com.boardgame.model.Game;
import com.boardgame.model.Play;
import com.boardgame.model.Player;
import com.boardgame.model.TopPlayerByGame;
import com.boardgame.repositories.PlayRepository;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Create a play")
    @PostMapping
    public @ResponseBody String addNewPlay(@RequestBody PlayDto playDto) {
        playRepository.save(translator.translatePlayDtoToPlay(playDto));
        return "Saved";
    }

    @ApiOperation(value = "Retrieve information about all plays")
    @GetMapping
    public @ResponseBody List<PlayDto> getAllPlays() {
        return StreamSupport.stream(playRepository.findAll().spliterator(), false).map(translator::translatePlayToPlayDto).collect(Collectors.toList());
    }

    @ApiOperation(value = "Retrieve information about a specific player")
    @GetMapping(value = "/{id}")
    public @ResponseBody PlayDto getPlayById(@PathVariable int id) {
        return playRepository.findById(id).map(translator::translatePlayToPlayDto).orElse(null);
    }

    @ApiOperation(value = "Retrieve the total of plays played")
    @GetMapping(value="/total")
    public @ResponseBody long getNumberPlays(){
        return playRepository.count();
    }

    @ApiOperation(value = "Retrieve the number wins for a specific player")
    @GetMapping(value="/total/players/{player}")
    public @ResponseBody long getNumberPlaysByWinnerId(@PathVariable Player player){
        return playRepository.countPlayByPlayer(player);
    }

    @ApiOperation(value = "Retrieve the number times a specific game has been played")
    @GetMapping(value="/total/{game}")
    public @ResponseBody long getNumberPlaysByGameId(@PathVariable Game game){
        return playRepository.countPlayByGame(game);
    }

    @ApiOperation(value = "Retrieve the player with the most wins for a specific game")
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

    @ApiOperation(value = "Retrieve the best score for a specific game")
    @GetMapping("/topScore/{gameId}")
    public @ResponseBody long getTopScoreByGameId(@PathVariable Game gameId){
        Play play = playRepository.findFirstByGameOrderByScoreDesc(gameId);
        return (play!=null)? play.getScore(): 0;
    }
}

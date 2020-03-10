package com.boardgame.controller;

import com.boardgame.dto.PlayerDto;
import com.boardgame.dto.translator.PlayerTranslator;
import com.boardgame.repositories.PlayerRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    private PlayerTranslator translator=new PlayerTranslator();

    @ApiOperation(value = "Create a player")
    @PostMapping
    public @ResponseBody String addNewPlayer(@RequestBody PlayerDto playerDto) {
        System.out.println(playerDto.toString());
        playerRepository.save(translator.translatePlayerDtoToPlayer(playerDto));
        return "Saved";
    }

    @ApiOperation(value = "Retrieve information about a specific player")
    @GetMapping(value = "/{id}")
    public @ResponseBody PlayerDto getPlayerById(@PathVariable int id){
        System.out.println("int id=" + id);
        return playerRepository.findById(id).map(translator::translatePlayerToPlayerDto).orElse(null);
    }

}
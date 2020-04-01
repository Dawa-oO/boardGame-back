package com.boardgame.controller;

import com.boardgame.dto.PlayerDto;
import com.boardgame.dto.translator.PlayerTranslator;
import com.boardgame.model.Player;
import com.boardgame.repositories.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private Environment env;

    private PlayerTranslator translator=new PlayerTranslator();

    @ApiOperation(value = "Create a player")
    @PostMapping
    public @ResponseBody String addNewPlayer(@RequestParam("player") String model, @RequestParam(value = "file", required = false) MultipartFile file) {
        // Transform JSON in String to PlayerDto
        ObjectMapper mapper = new ObjectMapper();
        PlayerDto playerDto = null;

        try {
            playerDto = mapper.readValue(model, PlayerDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error while parsing data to PlayerDto";
        }

        // Save in DB the playerDto
        Player playerSaved = playerRepository.save(translator.translatePlayerDtoToPlayer(playerDto));

        // Save the picture to external doc, using id for name
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File newFile = new File(env.getProperty("picture.path") + "images/players/" + playerSaved.getId() + ".jpg");
        try {
            inputStream = file.getInputStream();

            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Player and picture saved";
    }

    @ApiOperation(value = "Retrieve information about all players")
    @GetMapping
    public @ResponseBody List<PlayerDto> getAllPlayers() {
        return StreamSupport.stream(playerRepository.findAll().spliterator(), false).map(translator::translatePlayerToPlayerDto).collect(Collectors.toList());
    }

    @ApiOperation(value = "Retrieve information about a specific player")
    @GetMapping(value = "/{id}")
    public @ResponseBody PlayerDto getPlayerById(@PathVariable int id){
        return playerRepository.findById(id).map(translator::translatePlayerToPlayerDto).orElse(null);
    }

    @ApiOperation(value = "Retrieve the player with the most wins")
    @GetMapping("/topPlayer")
    public @ResponseBody PlayerDto getTopPlayer() {
        return translator.translatePlayerToPlayerDto(playerRepository.getTopPlayer());
    }

}

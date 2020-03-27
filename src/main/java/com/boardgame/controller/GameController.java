package com.boardgame.controller;

import com.boardgame.dto.GameDto;
import com.boardgame.dto.translator.GameTranslator;
import com.boardgame.model.Game;
import com.boardgame.repositories.GameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private Environment env;

    private GameTranslator translator = new GameTranslator();

    @PostMapping
    public @ResponseBody String addNewGame(@RequestParam("game") String model, @RequestParam(value = "file", required = false) MultipartFile file) {

        // Transform JSON in String to GameDto
        ObjectMapper mapper = new ObjectMapper();
        GameDto gameDto = null;
        try {
            gameDto = mapper.readValue(model, GameDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error while parsing data to GameDto";
        }

        // Save in DB the gameDto
        Game gameSaved = gameRepository.save(translator.translateGameDtoToGame(gameDto));

        // Save the picture to external doc, using id for name
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File newFile = new File(env.getProperty("picture.path") + "images/games/" + gameSaved.getId() + ".jpg");
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

        return "Game and picture saved";
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

    @GetMapping("/topGame")
    public @ResponseBody
    GameDto getTopGame() {
        return translator.translateGameToGameDto(gameRepository.getTopGame());
    }

    @GetMapping("/lastThree")
    public @ResponseBody List<GameDto> getThreeLastGamePlayed() {
        List<GameDto> threeLastGamesPlayed = new ArrayList<>();
        for (int id : gameRepository.getThreeLastPlayedGamesId()) {
            threeLastGamesPlayed.add(gameRepository.findById(id).map(translator::translateGameToGameDto).orElse(null));
        }
        return threeLastGamesPlayed;
    }

}

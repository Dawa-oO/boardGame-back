package com.boardgame.controller;

import com.boardgame.dto.PlayDto;
import com.boardgame.dto.translator.PlayTranslator;
import com.boardgame.repositories.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plays")
public class PlayController {
    @Autowired
    private PlayRepository playRepository;
    private PlayTranslator translator = new PlayTranslator();

    @PostMapping
    public @ResponseBody
    String addNewPlay(@RequestBody PlayDto playDto) {
        System.out.println(playDto.toString());
        playRepository.save(translator.translatePlayDtoToPlay(playDto));
        return "Saved";
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody PlayDto getPlayById(@PathVariable int id) {
        return playRepository.findById(id).map(translator::translatePlayToPlayDto).orElse(null);
    }

}

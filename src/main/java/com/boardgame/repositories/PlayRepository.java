package com.boardgame.repositories;

import com.boardgame.model.Game;
import com.boardgame.model.Play;
import com.boardgame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<Play, Integer> {
    Long countPlayByPlayer(Player id);

    Long countPlayByGame(Game id);
}

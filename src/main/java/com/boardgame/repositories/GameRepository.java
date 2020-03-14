package com.boardgame.repositories;

import com.boardgame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT * FROM BOARDGAMES.game WHERE ID IN (SELECT * FROM (SELECT game_id FROM BOARDGAMES.play GROUP BY game_id ORDER BY game_id DESC LIMIT 1) AS TEMP)", nativeQuery = true)
    Game getTopGame();

}

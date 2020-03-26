package com.boardgame.repositories;

import com.boardgame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT * FROM BOARDGAMES.game WHERE ID IN (SELECT * FROM (SELECT game_id FROM BOARDGAMES.play GROUP BY game_id ORDER BY count(game_id) DESC LIMIT 1) AS TEMP)", nativeQuery = true)
    Game getTopGame();

    @Query(value = "SELECT * FROM BOARDGAMES.game WHERE ID IN (SELECT * FROM (SELECT game_id FROM BOARDGAMES.play ORDER BY game_date DESC, id DESC LIMIT 3) AS TEMP)", nativeQuery = true)
    List<Game> getThreeLastPlayedGames();

}

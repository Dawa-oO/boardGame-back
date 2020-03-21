package com.boardgame.repositories;

import com.boardgame.model.Game;
import com.boardgame.model.Play;
import com.boardgame.model.Player;
import com.boardgame.model.TopPlayerByGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayRepository extends JpaRepository<Play, Integer> {
    Long countPlayByPlayer(Player id);

    Long countPlayByGame(Game id);

    @Query(value = "SELECT winner_id AS winnerId, COUNT(winner_id) AS nbVictory FROM BOARDGAMES.play WHERE game_id = ?1 GROUP BY winner_id LIMIT 1", nativeQuery = true)
    TopPlayerByGame getTopPlayerByGameId(int gameId);
}

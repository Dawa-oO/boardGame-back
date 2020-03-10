package com.boardgame.dto;

import com.boardgame.model.Game;
import com.boardgame.model.Player;

import java.sql.Date;

public class PlayDto {

    private Integer id;

    private String creationDate;

    private String gameDate;

    private int score;

    private Player player;

    private Game game;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "PlayDto{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", gameDate='" + gameDate + '\'' +
                ", score=" + score +
                ", player=" + player +
                ", game=" + game +
                '}';
    }
}

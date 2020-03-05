package com.boardgame.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "partie")
public class Play {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "GAME_DATE")
    private Date gameDate;

    @Column(name = "SCORE")
    private int score;

    @ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ID")
    private Player player;

    @ManyToOne(targetEntity = Game.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "GAME_ID", referencedColumnName = "ID")
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

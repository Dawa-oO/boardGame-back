package com.boardgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "jeu")
public class Game {
    @Id
    private Integer id;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NB_JOUEURS_MAX")
    private Integer maxNbPlayers;

    @Column(name = "NB_JOUEURS_MIN")
    private Integer minNbPlayers;

    @Column(name = "AVERAGE_TIME_PLAY")
    private Integer averageTimePlayed;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxNbPlayers() {
        return maxNbPlayers;
    }

    public void setMaxNbPlayers(Integer maxNbPlayers) {
        this.maxNbPlayers = maxNbPlayers;
    }

    public Integer getMinNbPlayers() {
        return minNbPlayers;
    }

    public void setMinNbPlayers(Integer minNbPlayers) {
        this.minNbPlayers = minNbPlayers;
    }

    public Integer getAverageTimePlayed() {
        return averageTimePlayed;
    }

    public void setAverageTimePlayed(Integer averageTimePlayed) {
        this.averageTimePlayed = averageTimePlayed;
    }
}

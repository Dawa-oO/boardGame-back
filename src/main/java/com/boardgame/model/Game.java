package com.boardgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "game")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date creationDate;

    private String name;

    private Integer maxNbPlayers;

    private Integer minNbPlayers;

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

package com.boardgame.dto;

import java.sql.Date;

public class GameDto {

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

    @Override
    public String toString() {
        return "GameDto{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", name='" + name + '\'' +
                ", maxNbPlayers=" + maxNbPlayers +
                ", minNbPlayers=" + minNbPlayers +
                ", averageTimePlayed=" + averageTimePlayed +
                '}';
    }
}

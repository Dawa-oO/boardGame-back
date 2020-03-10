package com.boardgame.dto;


import java.sql.Date;

public class PlayerDto {
    private Integer id;

    private String creationDate;

    private String pseudo;

    private String firstName;

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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}

package com.boardgame.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private Integer id;

    private String creationDate;

    private String pseudo;

    private String firstName;
}

package com.boardgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopPlayerByGameDto {
    private long winnerId;
    private long nbVictory;
}

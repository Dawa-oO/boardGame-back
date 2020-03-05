package com.boardgame.repositories;

import com.boardgame.model.Play;
import org.springframework.data.repository.CrudRepository;

public interface PlayRepository extends CrudRepository<Play, Integer> {
}

package com.boardgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "partie")
public class Play {

        @Id
        private Integer id;

        @Column(name = "CREATION_DATE")
        private Date creationDate;

        @Column(name = "GAME_DATE")
        private Date gameDate;

        @Column(name = "SCORE")
        private int score;

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

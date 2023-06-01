package com.example.howtoplaychessofflinefast_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PlayedGamesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer count;

    public PlayedGamesEntity() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer newCount) {
        this.count = newCount;
    }
}

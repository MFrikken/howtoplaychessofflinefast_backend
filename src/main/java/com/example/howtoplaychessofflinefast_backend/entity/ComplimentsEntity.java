package com.example.howtoplaychessofflinefast_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComplimentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String compliment;

    public ComplimentsEntity(String compliment){
        this.compliment = compliment;
    }

    public ComplimentsEntity() {

    }

    public String getCompliment() { return compliment; }
}

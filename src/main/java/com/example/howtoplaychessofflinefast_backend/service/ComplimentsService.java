package com.example.howtoplaychessofflinefast_backend.service;

import com.example.howtoplaychessofflinefast_backend.entity.ComplimentsEntity;
import com.example.howtoplaychessofflinefast_backend.repository.ComplimentsRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComplimentsService {

    private final ComplimentsRepository repository;

    @Autowired
    public ComplimentsService(ComplimentsRepository complimentsRepository) {
        this.repository = complimentsRepository;
    }

    public String getRandomCompliment() {
        Integer max = (int) repository.count();

        Random random = new Random();
        Integer id = random.nextInt(max);

        ComplimentsEntity entity = repository.getById(id);

        if (entity != null) return entity.getCompliment();

        return "No entries found for table = 'compliments'";
    }

    public String addCompliment(String compliment) throws Exception {
        ComplimentsEntity entity = new ComplimentsEntity(compliment);
        try {
            repository.save(entity);
            return "New compliment added to database.";
        } catch (Exception e) {
            throw e = new Exception("Could not save compliment.");
        }
    }

}

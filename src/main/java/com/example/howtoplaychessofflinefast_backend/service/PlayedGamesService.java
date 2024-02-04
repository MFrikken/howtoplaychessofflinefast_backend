package com.example.howtoplaychessofflinefast_backend.service;

import com.example.howtoplaychessofflinefast_backend.entity.PlayedGamesEntity;
import com.example.howtoplaychessofflinefast_backend.repository.PlayedGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayedGamesService {

    private final PlayedGamesRepository repository;

    @Autowired
    public PlayedGamesService(PlayedGamesRepository playedGamesRepository) {
        this.repository = playedGamesRepository;
    }

    public List<PlayedGamesEntity> getAll() {
        return repository.findAll();
    }

    public Integer getCount() {
       Optional<PlayedGamesEntity> currentCount = repository.findById(1);

       if (currentCount.isPresent()) {
           PlayedGamesEntity count = currentCount.get();
           return count.getCount();
       } else {
           throw new RuntimeException("No count found.");
       }
    }

    public Integer increaseCount() {
        Optional<PlayedGamesEntity> currentCount = repository.findById(1);

        if (currentCount.isPresent()) {
            PlayedGamesEntity newCount = currentCount.get();
            newCount.setCount(newCount.getCount() +1);
            repository.save(newCount);
            return newCount.getCount();
        } else {
            throw new RuntimeException("No count found.");
        }
    }
}

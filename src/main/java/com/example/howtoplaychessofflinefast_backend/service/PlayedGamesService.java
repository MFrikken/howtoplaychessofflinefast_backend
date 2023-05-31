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
       Optional currentCount = repository.findById(1);

       if (currentCount.isPresent()) {
           PlayedGamesEntity count = (PlayedGamesEntity) currentCount.get();
           return count.getId();
       } else {
           return 69;
           // throw new RuntimeException("No count found.");
       }
    }

    public Integer increaseCount() {
        Optional currentCount = repository.findById(1);

        if (currentCount.isPresent()) {
            PlayedGamesEntity newCount = (PlayedGamesEntity) currentCount.get();
            newCount.setCount(newCount.getCount() +1);
            repository.save(newCount);
            return newCount.getId();
        } else {
            return 69;
            // throw new RuntimeException("No count found.");
        }
    }
}

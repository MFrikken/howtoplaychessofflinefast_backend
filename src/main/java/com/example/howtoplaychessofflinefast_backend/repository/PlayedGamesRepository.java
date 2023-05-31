package com.example.howtoplaychessofflinefast_backend.repository;

import com.example.howtoplaychessofflinefast_backend.entity.PlayedGamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayedGamesRepository extends JpaRepository<PlayedGamesEntity, Integer> {

}

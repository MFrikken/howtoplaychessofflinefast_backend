package com.example.howtoplaychessofflinefast_backend.repository;

import com.example.howtoplaychessofflinefast_backend.entity.ComplimentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplimentsRepository extends JpaRepository<ComplimentsEntity, Integer> {

}

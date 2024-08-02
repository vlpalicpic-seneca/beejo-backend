package com.example.beejo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShowRepository extends MongoRepository<Show, String>{
    List<Show> findBySection(String section);
    List<Show> findByTitleContainingIgnoreCase(String title);
    List<Show> findByIsHero(Boolean isHero);
    List<Show> findBySectionAndIsHero(String section, Boolean isHero);
}

package com.example.beejo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShowService {

    @Autowired
    private ShowRepository showRepository; //Spring injects an instance of ShowRepository into showRepository

    public List<Show> getShows(String section){
        return showRepository.findBySection(section);
    }

    public List<Show> getHeroes(){
        return showRepository.findByIsHero(true);
    }

    public List<Show> getFeatured(String section, Boolean isHero){
        return showRepository.findBySectionAndIsHero(section, isHero);
    }

    public Show getShowDetails(String id){
        return showRepository.findById(id).orElse(null);
    }

    public List<Show> searchShows(String query){
        return showRepository.findByTitleContainingIgnoreCase(query);
    }

    public Show saveShow(Show show){
        return showRepository.save(show);
    }

    public void deleteShow(String id){
        showRepository.deleteById(id);
    }
}

package com.example.beejo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

    //1
    @PostMapping("/movies/add")
    public ResponseEntity<Show> addMovie(@RequestBody Show show){
        Show savedShow = showService.saveShow(show);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //2
    @GetMapping("/movies")
    public ResponseEntity<List<Show>> getMovies(){
        List<Show> movies = showService.getShows("movies");
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    //3
    @GetMapping("/series")
    public ResponseEntity<List<Show>> getSeries(){
        List<Show> series = showService.getShows("series");
        return new ResponseEntity<>(series, HttpStatus.OK);
    }

    //4
    @GetMapping("/titleSearch")
    public ResponseEntity<List<Show>> getShowByTitle(@RequestParam String query){
        List<Show> shows = showService.searchShows(query);
            return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    //5
    @GetMapping("/movies/featured")
    public ResponseEntity<List<Show>> getFeaturedMovies(@RequestParam Boolean isHero){
        List<Show> featMovies = showService.getFeatured("movies", isHero);
        return new ResponseEntity<>(featMovies, HttpStatus.OK);
    }

    //6
    @GetMapping("/series/featured")
    public ResponseEntity<List<Show>> getFeaturedSeries(@RequestParam Boolean isHero){
        List<Show> featSeries = showService.getFeatured("series", isHero);
        return new ResponseEntity<>(featSeries, HttpStatus.OK);
    }

    //7
    @GetMapping("/show/details")
    public ResponseEntity<Show> getShowDetails(@RequestParam String id){
        Show show = showService.getShowDetails(id);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    //8
    @PostMapping("/movies/edit")
    public ResponseEntity<Show> editMovie(@RequestBody Show show){
        Show editedShow = showService.saveShow(show);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //9
    @DeleteMapping("/show/delete")
    public ResponseEntity<Show> deleteShow(@RequestParam String id){
        showService.deleteShow(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //app
    @PostMapping("/series/add")
    public ResponseEntity<Show> addSeries(@RequestBody Show show){
        Show savedShow = showService.saveShow(show);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/series/edit")
    public ResponseEntity<Show> editSeries(@RequestBody Show show){
        Show editedShow = showService.saveShow(show);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/movies/details")
    public ResponseEntity<Show> getMovieDetails(@RequestParam String id){
        Show movieDetails = showService.getShowDetails(id);
        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }

    @GetMapping("/series/details")
    public ResponseEntity<Show> getSeriesDetails(@RequestParam String id){
        Show seriesDetails = showService.getShowDetails(id);
        return new ResponseEntity<>(seriesDetails, HttpStatus.OK);
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<Show>> getHeroes(){
        List<Show> heroes = showService.getHeroes();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

}
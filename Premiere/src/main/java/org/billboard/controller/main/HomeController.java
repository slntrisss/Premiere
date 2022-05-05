package org.billboard.controller.main;

import org.billboard.model.db.Cinema;
import org.billboard.model.poster.MoviePoster;
import org.billboard.service.dao.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.billboard.service.dao.MovieService;

import java.util.List;

@RestController
@RequestMapping("/main")
public class HomeController {

    private final MovieService movieService;
    private final CinemaService cinemaService;

    public HomeController(MovieService movieService,
                          CinemaService cinemaService) {
        this.movieService = movieService;
        this.cinemaService = cinemaService;
    }


    @GetMapping("/movie-list")
    public ResponseEntity<List<MoviePoster>> getAllMovies(){
        List<MoviePoster> posters = movieService.getAllMovies();
        return new ResponseEntity<>(posters, HttpStatus.OK);
    }

    @GetMapping("/cinema-list")
    public ResponseEntity<List<Cinema>> getAllCinemas(){
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/soon")
    public ResponseEntity<List<MoviePoster>> getToBeSoonReleasedMovies(){
        List<MoviePoster> posters = movieService.findToBeSoonReleasedMovies();
        return new ResponseEntity<>(posters, HttpStatus.OK);
    }

    @GetMapping("/for-kids")
    public ResponseEntity<List<MoviePoster>> findKidsMovies(){
        List<MoviePoster> posters = movieService.findKidsMovies();
        return new ResponseEntity<>(posters, HttpStatus.OK);
    }
}

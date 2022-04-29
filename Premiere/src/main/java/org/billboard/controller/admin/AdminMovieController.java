package org.billboard.controller.admin;

import org.billboard.model.db.Genre;
import org.billboard.model.dto.MovieDetail;
import org.billboard.model.poster.MoviePoster;
import org.billboard.service.dto.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/movie")
public class AdminMovieController {
    private final MovieDetailService movieDetailService;

    @Autowired
    public AdminMovieController(MovieDetailService movieDetailService) {
        this.movieDetailService = movieDetailService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MoviePoster>> getAllMovies(){
        List<MoviePoster> moviePosters = movieDetailService.getMoviePosters();
        return new ResponseEntity<>(moviePosters, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<MovieDetail> getMovieDetailById(@PathVariable("id")int ID){
        MovieDetail movieDetail = movieDetailService.getMovieDetails(ID);
        return new ResponseEntity<>(movieDetail, HttpStatus.OK);
    }
    @GetMapping("/genre-list")
    public ResponseEntity<List<Genre>> getGenreList(){
        List<Genre> genres = movieDetailService.getGenreList();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody MovieDetail movieDetail){
        movieDetailService.save(movieDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDetail movieDetail){
        movieDetailService.update(movieDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteMovie(@PathVariable("id")int ID){
        movieDetailService.deleteMovieById(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/role-detail/{id}/delete")
    public ResponseEntity<?> deleteRoleDetailById(@PathVariable("id")int ID){
        movieDetailService.deleteRoleDetailById(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}/genre/{genreId}/delete")
    public ResponseEntity<?> deleteGenreById(@PathVariable("movieId")int movieId,
                                             @PathVariable("genreId")int genreId){
        movieDetailService.deleteGenreById(movieId, genreId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

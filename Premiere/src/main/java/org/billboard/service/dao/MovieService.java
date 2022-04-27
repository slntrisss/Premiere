package org.billboard.service.dao;

import org.billboard.model.detail.MovieDetail;
import org.billboard.model.poster.MoviePoster;
import org.springframework.beans.factory.annotation.Autowired;
import org.billboard.repository.dao.daoImpl.MovieRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MoviePoster> getAllMovies(){
        List<MoviePoster> posters = movieRepository.findAllMovies();
        formatDate(posters);
        return posters;
    }

    public List<MoviePoster> findToBeSoonReleasedMovies(){
        List<MoviePoster> posters = movieRepository.findToBeSoonReleasedMovies();
        formatDate(posters);
        return posters;
    }

    public List<MoviePoster> findKidsMovies(){
        List<MoviePoster> posters = movieRepository.findMoviesForKids();
        formatDate(posters);
        return posters;
    }

    public MovieDetail findMovieById(int ID){
        return movieRepository.findMovieDetails(ID);
    }

    private void formatDate(List<MoviePoster> posters){
        for(MoviePoster poster: posters){
            DateFormat format = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
            poster.setFormattedDate(format.format(poster.getReleaseDate()));
        }
    }
}

package org.billboard.model.detail;

import org.billboard.model.db.Detail;
import org.billboard.model.db.Movie;
import org.billboard.model.db.MovieGenre;


public class MovieDetail {
    private Movie movie;
    private Detail detail;
    private String directors;
    private String actors;
    private MovieGenre movieGenre;

    public MovieDetail() {
    }

    public MovieDetail(Movie movie, Detail detail, String directors,
                       String actors, MovieGenre movieGenre) {
        this.movie = movie;
        this.detail = detail;
        this.directors = directors;
        this.actors = actors;
        this.movieGenre = movieGenre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }
}

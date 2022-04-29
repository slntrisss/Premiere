package org.billboard.model.detail;

import org.billboard.model.db.Detail;
import org.billboard.model.db.Movie;


public class MovieInfo {
    private Movie movie;
    private Detail detail;
    private String directors;
    private String actors;
    private String genres;

    public MovieInfo() {
    }

    public MovieInfo(Movie movie, Detail detail, String directors,
                     String actors, String genres) {
        this.movie = movie;
        this.detail = detail;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
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

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}

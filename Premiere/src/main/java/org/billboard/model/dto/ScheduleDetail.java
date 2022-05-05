package org.billboard.model.dto;

import org.billboard.model.db.CinemaHall;
import org.billboard.model.db.Movie;

import java.util.LinkedList;
import java.util.List;

public class ScheduleDetail {
    List<Movie> movies;
    List<CinemaHall> cinemaHalls;

    public ScheduleDetail() {
        movies = new LinkedList<>();
        cinemaHalls = new LinkedList<>();
    }

    public ScheduleDetail(List<Movie> movies, List<CinemaHall> cinemaHalls) {
        this.movies = movies;
        this.cinemaHalls = cinemaHalls;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

    public void setCinemaHalls(List<CinemaHall> cinemaHalls) {
        this.cinemaHalls = cinemaHalls;
    }
}

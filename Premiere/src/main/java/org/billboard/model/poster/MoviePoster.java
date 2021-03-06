package org.billboard.model.poster;

import java.util.Date;

public class MoviePoster {
    private int movieId;
    private String movieName;
    private String moviePoster;
    private Date releaseDate;
    private String genre;
    private String formattedDate;

    public MoviePoster() {
    }

    public MoviePoster(int movieId,String movieName, String moviePoster, Date releaseDate, String genre) {
        this.movieId=movieId;
        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }
}

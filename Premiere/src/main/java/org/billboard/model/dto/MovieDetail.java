package org.billboard.model.dto;

import org.billboard.model.db.Detail;
import org.billboard.model.db.Movie;
import org.billboard.model.db.MovieGenre;
import org.billboard.model.db.RoleDetail;

import java.util.LinkedList;
import java.util.List;

public class MovieDetail {
    private Movie movie;
    private Detail detail;
    private List<RoleDetail> roleDetails;
    private MovieGenre genres;

    public MovieDetail() {
        roleDetails = new LinkedList<>();
    }

    public MovieDetail(Movie movie, Detail detail, List<RoleDetail> roleDetails, MovieGenre genres) {
        this.movie = movie;
        this.detail = detail;
        this.roleDetails = roleDetails;
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

    public List<RoleDetail> getRoleDetails() {
        return roleDetails;
    }

    public void setRoleDetails(List<RoleDetail> roleDetails) {
        this.roleDetails = roleDetails;
    }

    public MovieGenre getGenres() {
        return genres;
    }

    public void setGenres(MovieGenre genres) {
        this.genres = genres;
    }
}

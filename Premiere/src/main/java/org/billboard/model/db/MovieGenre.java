package org.billboard.model.db;

import java.util.List;

public class MovieGenre {
    private List<Genre> genres;

    public MovieGenre() {
    }

    public MovieGenre(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}

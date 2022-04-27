package org.billboard.model.db;

public class MovieGenre {
    private String genres;

    public MovieGenre() {
    }

    public MovieGenre(String genres) {
        this.genres = genres;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}

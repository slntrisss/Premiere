package org.billboard.model.db;

public class Genre {
    private int genreId;
    private String genreType;

    public Genre() {
    }

    public Genre(int genreId, String genreType) {
        this.genreId = genreId;
        this.genreType = genreType;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }
}

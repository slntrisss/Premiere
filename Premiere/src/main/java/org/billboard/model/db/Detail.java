package org.billboard.model.db;

import java.io.Serializable;
import java.util.Date;

public class Detail implements Serializable {
    private int detailId;
    private String country;
    private String description;
    private String language;
    private int duration;
    private Date releaseDate;
    private int ageRating;
    private double rating;
    private long numberOfVotes;

    public Detail() {
    }

    public Detail(int detailId, String countryName, String description,
                  String language, int duration, Date releaseDate, int ageRating,
                  double rating, long numberOfVotes) {
        this.detailId = detailId;
        this.country = countryName;
        this.description = description;
        this.language = language;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.rating = rating;
        this.numberOfVotes = numberOfVotes;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

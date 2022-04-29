package org.billboard.model.detail;

import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;

public class BookingSchedule {
    private String imageFile;
    private String movieName;
    private String cinemaName;
    private String hallName;
    private int ageRating;
    private Schedule schedule;
    private String language;
    private TicketType ticketType;

    public BookingSchedule() {
    }

    public BookingSchedule(String imageFile, String movieName, String cinemaName,
                           String hallName, int ageRating, Schedule schedule, String language,
                           TicketType ticketType) {
        this.imageFile = imageFile;
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.hallName = hallName;
        this.ageRating = ageRating;
        this.schedule = schedule;
        this.language = language;
        this.ticketType = ticketType;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}

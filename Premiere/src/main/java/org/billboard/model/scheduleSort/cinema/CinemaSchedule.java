package org.billboard.model.scheduleSort.cinema;

import org.billboard.model.db.Movie;
import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;

public class CinemaSchedule {
    private String hallName;
    private Movie movie;
    private Schedule schedule;
    private String language;
    private TicketType ticketType;

    public CinemaSchedule() {
    }

    public CinemaSchedule(String hallName, Movie movie, Schedule schedule,
                          String language, TicketType ticketType) {
        this.hallName = hallName;
        this.movie = movie;
        this.schedule = schedule;
        this.language = language;
        this.ticketType = ticketType;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

package org.billboard.model.dto;

import org.billboard.model.db.CinemaHall;
import org.billboard.model.db.Movie;
import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;

public class CinemaScheduleByHall {
    private int cinemaId;
    private Movie movie;
    private CinemaHall cinemaHall;
    private Schedule schedule;
    private TicketType ticketType;

    public CinemaScheduleByHall() {
    }

    public CinemaScheduleByHall(int cinemaId,
                                Movie movie,
                                CinemaHall cinemaHall,
                                Schedule schedule,
                                TicketType ticketType) {
        this.cinemaId = cinemaId;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.schedule = schedule;
        this.ticketType = ticketType;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}

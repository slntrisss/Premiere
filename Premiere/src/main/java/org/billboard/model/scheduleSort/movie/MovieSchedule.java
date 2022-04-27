package org.billboard.model.scheduleSort.movie;


import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;
import org.billboard.model.scheduleSort.data.Cinema;

public class MovieSchedule {
    private Schedule schedule;
    private Cinema cinema;
    private TicketType ticketType;
    private String language;

    public MovieSchedule() {
    }

    public MovieSchedule(Schedule schedule, Cinema cinema, TicketType ticketType, String language) {
        this.schedule = schedule;
        this.cinema = cinema;
        this.ticketType = ticketType;
        this.language = language;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

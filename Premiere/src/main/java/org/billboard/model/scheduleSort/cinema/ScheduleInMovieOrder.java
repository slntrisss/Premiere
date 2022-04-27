package org.billboard.model.scheduleSort.cinema;

import org.billboard.model.db.Movie;
import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;

import java.util.LinkedList;
import java.util.List;

public class ScheduleInMovieOrder {
    private Movie movie;
    private List<Schedule> schedules;
    private List<TicketType> ticketTypes;
    private List<String> languages;
    private List<String> hallName;

    public ScheduleInMovieOrder() {
        schedules = new LinkedList<>();
        ticketTypes = new LinkedList<>();
        languages = new LinkedList<>();
        hallName = new LinkedList<>();
    }

    public ScheduleInMovieOrder(Movie movie, List<Schedule> schedules,
                                List<TicketType> ticketTypes, List<String> languages,
                                List<String> hallName) {
        this.movie = movie;
        this.schedules = schedules;
        this.ticketTypes = ticketTypes;
        this.languages = languages;
        this.hallName = hallName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getHallName() {
        return hallName;
    }

    public void setHallName(List<String> hallName) {
        this.hallName = hallName;
    }
}

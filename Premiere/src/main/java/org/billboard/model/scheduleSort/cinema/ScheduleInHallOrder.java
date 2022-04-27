package org.billboard.model.scheduleSort.cinema;

import org.billboard.model.db.Movie;
import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;

import java.util.LinkedList;
import java.util.List;

public class ScheduleInHallOrder {
    private String hallName;
    private List<Schedule> schedules;
    private List<TicketType> ticketTypes;
    private List<Movie> movies;
    private List<String> languages;

    public ScheduleInHallOrder() {
        schedules = new LinkedList<>();
        ticketTypes = new LinkedList<>();
        movies = new LinkedList<>();
        languages = new LinkedList<>();
    }

    public ScheduleInHallOrder(String hallName, List<Schedule> schedules,
                               List<TicketType> ticketTypes, List<Movie> movies,
                               List<String> languages) {
        this.hallName = hallName;
        this.schedules = schedules;
        this.ticketTypes = ticketTypes;
        this.movies = movies;
        this.languages = languages;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}

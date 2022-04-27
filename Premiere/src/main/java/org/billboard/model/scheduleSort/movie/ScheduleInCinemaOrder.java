package org.billboard.model.scheduleSort.movie;

import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;
import org.billboard.model.scheduleSort.data.Cinema;

import java.util.LinkedList;
import java.util.List;

public class ScheduleInCinemaOrder {
    private Cinema cinema;
    private List<Schedule> scheduleList;
    private List<TicketType> ticketTypes;
    private List<String> language;

    public ScheduleInCinemaOrder() {
        scheduleList = new LinkedList<>();
        ticketTypes = new LinkedList<>();
        language = new LinkedList<>();
    }

    public ScheduleInCinemaOrder(Cinema cinema, List<Schedule> scheduleList,
                                 List<TicketType> ticketTypes, List<String> language) {
        this.cinema = cinema;
        this.scheduleList = scheduleList;
        this.ticketTypes = ticketTypes;
        this.language = language;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }
}

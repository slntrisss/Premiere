package org.billboard.service.dao;

import org.billboard.model.scheduleSort.cinema.CinemaSchedule;
import org.billboard.model.scheduleSort.cinema.ScheduleInHallOrder;
import org.billboard.model.scheduleSort.cinema.ScheduleInMovieOrder;
import org.billboard.model.scheduleSort.movie.ScheduleInCinemaOrder;
import org.billboard.model.scheduleSort.movie.MovieSchedule;
import org.billboard.repository.scheduleSort.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<MovieSchedule> getScheduleByTimeOrder(int ID){
        return scheduleRepository.getScheduleOrderByTime(ID);
    }

    public List<ScheduleInCinemaOrder> getScheduleByCinemaOrder(int ID){
        List<MovieSchedule> schedules = scheduleRepository.getScheduleOrderByCinema(ID);
        List<ScheduleInCinemaOrder> cinemaSchedules = new LinkedList<>();
        ScheduleInCinemaOrder cinemaOrder = new ScheduleInCinemaOrder();
        for(MovieSchedule schedule: schedules){
            if(cinemaOrder.getCinema() == null){
                cinemaOrder.setCinema(schedule.getCinema());
                cinemaOrder.getScheduleList().add(schedule.getSchedule());
                cinemaOrder.getTicketTypes().add(schedule.getTicketType());
                cinemaOrder.getLanguage().add(schedule.getLanguage());
            }
            else if(cinemaOrder.getCinema().getName().equals(schedule.getCinema().getName())){
                cinemaOrder.getScheduleList().add(schedule.getSchedule());
                cinemaOrder.getTicketTypes().add(schedule.getTicketType());
                cinemaOrder.getLanguage().add(schedule.getLanguage());
            }
            else{
                cinemaSchedules.add(cinemaOrder);
                cinemaOrder = new ScheduleInCinemaOrder();
            }
        }
        if(cinemaOrder.getCinema() != null)
            cinemaSchedules.add(cinemaOrder);
        return cinemaSchedules;
    }

    public List<ScheduleInHallOrder> getScheduleInHallOrder(int ID){
        List<CinemaSchedule> cinemaSchedules = scheduleRepository.getScheduleOrderByHall(ID);
        List<ScheduleInHallOrder> hallSchedule = new LinkedList<>();
        ScheduleInHallOrder hallOrder = new ScheduleInHallOrder();
        for(CinemaSchedule schedule: cinemaSchedules){
            if(hallOrder.getHallName() == null){
                hallOrder.setHallName(schedule.getHallName());
                hallOrder.getSchedules().add(schedule.getSchedule());
                hallOrder.getTicketTypes().add(schedule.getTicketType());
                hallOrder.getLanguages().add(schedule.getLanguage());
                hallOrder.getMovies().add(schedule.getMovie());
            }
            else if(hallOrder.getHallName().equals(schedule.getHallName())){
                hallOrder.getSchedules().add(schedule.getSchedule());
                hallOrder.getTicketTypes().add(schedule.getTicketType());
                hallOrder.getLanguages().add(schedule.getLanguage());
                hallOrder.getMovies().add(schedule.getMovie());
            }
            else{
                hallSchedule.add(hallOrder);
                hallOrder = new ScheduleInHallOrder();
                hallOrder.setHallName(schedule.getHallName());
                hallOrder.getSchedules().add(schedule.getSchedule());
                hallOrder.getTicketTypes().add(schedule.getTicketType());
                hallOrder.getLanguages().add(schedule.getLanguage());
                hallOrder.getMovies().add(schedule.getMovie());
            }
        }
        if(hallOrder.getHallName() != null)
            hallSchedule.add(hallOrder);
        return hallSchedule;
    }

    public List<ScheduleInMovieOrder> getScheduleInMovieOrder(int ID){
        List<CinemaSchedule> cinemaSchedules = scheduleRepository.getScheduleOrderByHall(ID);
        List<ScheduleInMovieOrder> movieSchedule = new LinkedList<>();

        ScheduleInMovieOrder movieOrder = new ScheduleInMovieOrder();
        for(CinemaSchedule schedule: cinemaSchedules){
            if(movieOrder.getMovie() == null){
                movieOrder.setMovie(schedule.getMovie());
                movieOrder.getSchedules().add(schedule.getSchedule());
                movieOrder.getTicketTypes().add(schedule.getTicketType());
                movieOrder.getLanguages().add(schedule.getLanguage());
                movieOrder.getHallName().add(schedule.getHallName());
            }
            else if(movieOrder.getMovie().getMovieName().equals(schedule.getMovie().getMovieName())){
                movieOrder.getSchedules().add(schedule.getSchedule());
                movieOrder.getTicketTypes().add(schedule.getTicketType());
                movieOrder.getLanguages().add(schedule.getLanguage());
                movieOrder.getHallName().add(schedule.getHallName());
            }
            else{
                movieSchedule.add(movieOrder);
                movieOrder = new ScheduleInMovieOrder();
                movieOrder.setMovie(schedule.getMovie());
                movieOrder.getSchedules().add(schedule.getSchedule());
                movieOrder.getTicketTypes().add(schedule.getTicketType());
                movieOrder.getLanguages().add(schedule.getLanguage());
                movieOrder.getHallName().add(schedule.getHallName());
            }
        }
        if(movieOrder.getMovie() != null)
            movieSchedule.add(movieOrder);

        return movieSchedule;
    }
}

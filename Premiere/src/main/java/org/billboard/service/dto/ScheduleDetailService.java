package org.billboard.service.dto;

import org.billboard.model.db.CinemaHall;
import org.billboard.model.db.Movie;
import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;
import org.billboard.model.dto.CinemaScheduleByHall;
import org.billboard.model.dto.ScheduleDetail;
import org.billboard.repository.dao.daoImpl.CinemaHallRepository;
import org.billboard.repository.dao.daoImpl.MovieRepository;
import org.billboard.repository.dao.daoImpl.TicketTypeRepository;
import org.billboard.repository.scheduleSort.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleDetailService {
    private final MovieRepository movieRepository;
    private final CinemaHallRepository cinemaHallRepository;
    private final ScheduleRepository scheduleRepository;
    private final TicketTypeRepository ticketTypeRepository;

    public ScheduleDetailService(MovieRepository movieRepository,
                                 CinemaHallRepository cinemaHallRepository,
                                 ScheduleRepository scheduleRepository,
                                 TicketTypeRepository ticketTypeRepository) {
        this.movieRepository = movieRepository;
        this.cinemaHallRepository = cinemaHallRepository;
        this.scheduleRepository = scheduleRepository;
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public ScheduleDetail getScheduleDetail(int cinemaId){
        List<Movie> movieList = movieRepository.getMoviesRollingToday();
        List<CinemaHall> cinemaHalls = cinemaHallRepository.getCinemaHalls(cinemaId);
        ScheduleDetail scheduleDetail = new ScheduleDetail();
        scheduleDetail.setCinemaHalls(cinemaHalls);
        scheduleDetail.setMovies(movieList);
        return scheduleDetail;
    }

    public void addSchedule(CinemaScheduleByHall cinemaScheduleByHall){
        Movie movie = cinemaScheduleByHall.getMovie();
        CinemaHall cinemaHall = cinemaScheduleByHall.getCinemaHall();
        Schedule schedule = cinemaScheduleByHall.getSchedule();
        TicketType ticketType = cinemaScheduleByHall.getTicketType();


        scheduleRepository.addSchedule(schedule, cinemaHall.getCinemaHallId(),
                movie.getMovieId());
        ticketTypeRepository.save(ticketType, scheduleRepository.getLastId());
    }
}

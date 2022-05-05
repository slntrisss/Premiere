package org.billboard.controller.main;

import org.billboard.model.detail.MovieInfo;
import org.billboard.model.scheduleSort.movie.ScheduleInCinemaOrder;
import org.billboard.model.scheduleSort.movie.MovieSchedule;
import org.billboard.service.dao.MovieService;
import org.billboard.service.dao.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final ScheduleService scheduleService;

    public MovieController(MovieService movieService,
                           ScheduleService scheduleService) {
        this.movieService = movieService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieInfo> getMovieDetails(@PathVariable("id") int ID){
        MovieInfo detail = movieService.findMovieById(ID);
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @GetMapping("/schedule/time-order/{id}")
    public ResponseEntity<List<MovieSchedule>> getScheduleByTimeOrder(@PathVariable("id")int ID){
        List<MovieSchedule> schedule = scheduleService.getScheduleByTimeOrder(ID);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @GetMapping("/schedule/cinema-order/{id}")
    public ResponseEntity<List<ScheduleInCinemaOrder>> getScheduleByCinemaOrder(@PathVariable("id")int ID){
        List<ScheduleInCinemaOrder> schedule = scheduleService.getScheduleByCinemaOrder(ID);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}

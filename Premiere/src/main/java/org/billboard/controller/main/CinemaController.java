package org.billboard.controller.main;

import org.billboard.model.db.Cinema;
import org.billboard.model.db.CinemaInfo;
import org.billboard.model.scheduleSort.cinema.ScheduleInHallOrder;
import org.billboard.model.scheduleSort.cinema.ScheduleInMovieOrder;
import org.billboard.model.scheduleSort.movie.ScheduleInCinemaOrder;
import org.billboard.service.dao.CinemaService;
import org.billboard.service.dao.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    private final CinemaService cinemaService;
    private final ScheduleService scheduleService;

    @Autowired
    public CinemaController(CinemaService cinemaService,
                            ScheduleService scheduleService) {
        this.cinemaService = cinemaService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable("id")int ID){
        CinemaInfo cinema = cinemaService.getCinemaById(ID);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @GetMapping("/schedule/hall-order/{id}")
    public ResponseEntity<List<ScheduleInHallOrder>> getScheduleByCinemaOrder(@PathVariable("id")int ID){
        List<ScheduleInHallOrder> schedule = scheduleService.getScheduleInHallOrder(ID);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @GetMapping("/schedule/movie-order/{id}")
    public ResponseEntity<List<ScheduleInMovieOrder>> getScheduleByMovieOrder(@PathVariable("id")int ID){
        List<ScheduleInMovieOrder> schedule = scheduleService.getScheduleInMovieOrder(ID);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}

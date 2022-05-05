package org.billboard.controller.admin;

import org.billboard.model.dto.CinemaScheduleByHall;
import org.billboard.model.dto.ScheduleDetail;
import org.billboard.service.dto.ScheduleDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/schedule")
public class AdminScheduleController {

    private final ScheduleDetailService scheduleDetailService;

    public AdminScheduleController(ScheduleDetailService scheduleDetailService) {
        this.scheduleDetailService = scheduleDetailService;
    }

    @GetMapping("/detail/{cinemaId}")
    public ResponseEntity<ScheduleDetail> getScheduleDetail(@PathVariable("cinemaId")int cinemaId){
        ScheduleDetail scheduleDetail = scheduleDetailService.getScheduleDetail(cinemaId);
        return new ResponseEntity<>(scheduleDetail, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSchedule(@RequestBody CinemaScheduleByHall cinemaScheduleByHall){
        scheduleDetailService.addSchedule(cinemaScheduleByHall);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

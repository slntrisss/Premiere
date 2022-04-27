package org.billboard.controller;

import org.billboard.model.db.Cinema;
import org.billboard.model.db.CinemaInfo;
import org.billboard.model.dto.CinemaDetail;
import org.billboard.service.dao.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class AdminController {

    private final CinemaService cinemaService;

    public AdminController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cinema>> getCinemas(){
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }
}

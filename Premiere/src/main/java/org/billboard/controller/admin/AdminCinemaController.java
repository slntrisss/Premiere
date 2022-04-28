package org.billboard.controller.admin;

import org.billboard.model.db.Cinema;
import org.billboard.model.dto.CinemaDetail;
import org.billboard.service.dto.CinemaDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/cinema")
public class AdminCinemaController {

    private final CinemaDetailService cinemaDetailService;

    public AdminCinemaController(CinemaDetailService cinemaDetailService) {
        this.cinemaDetailService = cinemaDetailService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Cinema>> getCinemas(){
        List<Cinema> cinemas = cinemaDetailService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<CinemaDetail> getCinemaDetailById(@PathVariable("id")int ID){
        CinemaDetail cinemaDetails = cinemaDetailService.getCinemaDetails(ID);
        return new ResponseEntity<>(cinemaDetails, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCinema(@RequestBody CinemaDetail cinemaDetail){
        cinemaDetailService.save(cinemaDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCinema(@RequestBody CinemaDetail cinemaDetail){
        cinemaDetailService.update(cinemaDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteCinemaById(@PathVariable("id")int ID){
        cinemaDetailService.deleteCinema(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("cinema-hall/{id}/delete")
    public ResponseEntity<?> deleteCinemaHallById(@PathVariable("id")int ID){
        cinemaDetailService.deleteCinemaHallById(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

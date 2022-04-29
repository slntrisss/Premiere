package org.billboard.controller.booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingController{

    @GetMapping
    public void getScheduleDetail(@RequestParam("movieId")int movieId,
                                  @RequestParam("cinemaId")int cinemaId){

    }
}

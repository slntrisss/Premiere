package org.billboard.controller.booking;

import org.billboard.model.db.CinemaSeat;
import org.billboard.model.dto.BookingSchedule;
import org.billboard.service.booking.BookingScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController{

    private final BookingScheduleService bookingScheduleService;

    public BookingController(BookingScheduleService bookingScheduleService) {
        this.bookingScheduleService = bookingScheduleService;
    }

    @GetMapping
    public ResponseEntity<BookingSchedule> getScheduleDetail(@RequestParam("movieId")int movieId,
                                            @RequestParam("cinemaId")int cinemaId,
                                            @RequestParam("scheduleDate")String scheduleDate,
                                            @RequestParam("startTime")String startTime,
                                            @RequestParam("hallId")int hallId){
        BookingSchedule bookingSchedule = bookingScheduleService.getBookingSchedule(
                movieId, cinemaId, scheduleDate, startTime, hallId
        );
        return new ResponseEntity<>(bookingSchedule, HttpStatus.OK);
    }

    @GetMapping("/get_reserved_seats")
    public ResponseEntity<List<CinemaSeat>> getReservedSeats(@RequestParam("hallId") int hallId,
                                                             @RequestParam("scheduleId")int scheduleId){
        List<CinemaSeat> reservedSeats = bookingScheduleService.getReservedSeats(hallId, scheduleId);
        return new ResponseEntity<>(reservedSeats, HttpStatus.OK);
    }
}

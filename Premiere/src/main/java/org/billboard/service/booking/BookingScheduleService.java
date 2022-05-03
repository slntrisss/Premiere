package org.billboard.service.booking;

import org.billboard.model.db.CinemaSeat;
import org.billboard.model.dto.BookingSchedule;
import org.billboard.repository.booking.BookingScheduleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingScheduleService {
    private final BookingScheduleRepository bookingScheduleRepository;

    public BookingScheduleService(BookingScheduleRepository bookingScheduleRepository) {
        this.bookingScheduleRepository = bookingScheduleRepository;
    }

    public BookingSchedule getBookingSchedule(int movieId, int cinemaId, String scheduleDate,
                                              String startTime, int hallId){
        BookingSchedule bookingSchedule = bookingScheduleRepository.getScheduleDetail(movieId, cinemaId,
                scheduleDate, startTime, hallId);
        List<CinemaSeat> reservedSeats = getReservedSeats(hallId, bookingSchedule.
                getSchedule().getScheduleId());
        bookingSchedule.setReservedSeats(reservedSeats);
        return bookingSchedule;
    }

    public List<CinemaSeat> getReservedSeats(int hallId, int scheduleId){
        return bookingScheduleRepository.getReservedSeats(hallId, scheduleId);
    }
}

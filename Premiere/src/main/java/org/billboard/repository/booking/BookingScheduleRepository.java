package org.billboard.repository.booking;

import org.billboard.model.detail.BookingSchedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookingScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BookingSchedule getScheduleDetail(int movieId, int cinemaId){
        String sql = "";
        return null;
    }
}

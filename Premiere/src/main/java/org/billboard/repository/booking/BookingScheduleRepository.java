package org.billboard.repository.booking;

import org.billboard.model.db.CinemaSeat;
import org.billboard.model.dto.BookingSchedule;
import org.billboard.repository.booking.mapper.BookingScheduleMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BookingScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookingScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BookingSchedule getScheduleDetail(int movieId, int cinemaId, String scheduleDate, String startTime,
                                             int hallId){
        String sql = "select ch.hall_name, m.movie_name, m.image_file, c.CINEMA_NAME, " +
                "s.schedule_id, s.start_time, d.AGE_RATING, " +
                "       s.SCHEDULE_DATE, d.movie_lang, t.adult_ticket, t.youth_ticket, " +
                "t.student_ticket, ch.number_of_rows, ch.number_of_cols " +
                "from movie m, cinema c, cinema_hall ch, detail d, " +
                "schedule s, ticket_type t " +
                "where m.movie_id=d.detail_id " +
                "  and m.movie_id=s.movie_id " +
                "  and s.schedule_id=t.schedule_id " +
                "  and s.cinema_hall_id=ch.cinema_hall_id " +
                "  and ch.cinema_id=c.cinema_id " +
                "  and c.cinema_id=? " +
                "  and m.MOVIE_ID=? " +
                "  and ?=to_char(s.schedule_date) " +
                "  and s.START_TIME=? " +
                "  and ch.cinema_hall_id=? " +
                "  order by ch.hall_name, s.start_time";
        return jdbcTemplate.queryForObject(sql, new BookingScheduleMapper(), cinemaId,
                movieId, scheduleDate, startTime, hallId);
    }

    public List<CinemaSeat> getReservedSeats(int hallId, int scheduleId){
        String sql = "SELECT * FROM cinema_seat WHERE cinema_hall_id=? and schedule_id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CinemaSeat.class),
                hallId, scheduleId);
    }
}

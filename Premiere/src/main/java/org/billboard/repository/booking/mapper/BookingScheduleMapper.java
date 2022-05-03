package org.billboard.repository.booking.mapper;

import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;
import org.billboard.model.dto.BookingSchedule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookingScheduleMapper implements RowMapper<BookingSchedule> {
    @Override
    public BookingSchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        BookingSchedule bookingSchedule = new BookingSchedule();
        Schedule schedule = new Schedule();
        TicketType ticketType = new TicketType();

        schedule.setScheduleId(resultSet.getInt("schedule_id"));
        schedule.setStartTime(resultSet.getString("start_time"));
        schedule.setDate(resultSet.getDate("schedule_date"));

        ticketType.setAdultTicket(resultSet.getString("adult_ticket"));
        ticketType.setYouthTicket(resultSet.getString("youth_ticket"));
        ticketType.setAdultTicket(resultSet.getString("student_ticket"));

        bookingSchedule.setSchedule(schedule);
        bookingSchedule.setTicketType(ticketType);
        bookingSchedule.setAgeRating(resultSet.getInt("age_rating"));
        bookingSchedule.setCinemaName(resultSet.getString("cinema_name"));
        bookingSchedule.setLanguage(resultSet.getString("movie_lang"));
        bookingSchedule.setHallName(resultSet.getString("hall_name"));
        bookingSchedule.setMovieName(resultSet.getString("movie_name"));
        bookingSchedule.setNumberOfRows(resultSet.getInt("number_of_rows"));
        bookingSchedule.setNumberOfCols(resultSet.getInt("number_of_cols"));

        return bookingSchedule;
    }
}

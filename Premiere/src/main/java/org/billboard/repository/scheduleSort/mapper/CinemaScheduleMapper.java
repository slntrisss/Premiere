package org.billboard.repository.scheduleSort.mapper;

import org.billboard.model.db.Movie;
import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;
import org.billboard.model.scheduleSort.cinema.CinemaSchedule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaScheduleMapper implements RowMapper<CinemaSchedule> {
    @Override
    public CinemaSchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        CinemaSchedule cinemaSchedule = new CinemaSchedule();
        Schedule schedule = new Schedule();
        Movie movie = new Movie();
        TicketType ticketType = new TicketType();

        schedule.setDate(resultSet.getDate("schedule_date"));
        schedule.setStartTime(resultSet.getString("start_time"));

        ticketType.setAdultTicket(resultSet.getString("adult_ticket"));
        ticketType.setYouthTicket(resultSet.getString("youth_ticket"));
        ticketType.setStudentTicket(resultSet.getString("student_ticket"));

        movie.setMovieName(resultSet.getString("movie_name"));
        movie.setOriginalName(resultSet.getString("original_name"));

        cinemaSchedule.setMovie(movie);
        cinemaSchedule.setSchedule(schedule);
        cinemaSchedule.setTicketType(ticketType);
        cinemaSchedule.setLanguage(resultSet.getString("movie_lang"));
        cinemaSchedule.setHallName(resultSet.getString("hall_name"));
        return cinemaSchedule;
    }
}

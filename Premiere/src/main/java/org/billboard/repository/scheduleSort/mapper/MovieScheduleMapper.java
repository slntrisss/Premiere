package org.billboard.repository.scheduleSort.mapper;

import org.billboard.model.db.Schedule;
import org.billboard.model.db.TicketType;
import org.billboard.model.scheduleSort.data.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieScheduleMapper implements RowMapper<org.billboard.model.scheduleSort.movie.MovieSchedule> {
    @Override
    public org.billboard.model.scheduleSort.movie.MovieSchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        org.billboard.model.scheduleSort.movie.MovieSchedule scheduleInTimeOrder = new org.billboard.model.scheduleSort.movie.MovieSchedule();
        Schedule schedule = new Schedule();
        TicketType ticketType = new TicketType();
        Cinema cinema = new Cinema();

        cinema.setName(resultSet.getString("cinema_name"));
        cinema.setHallName(resultSet.getString("hall_name"));
        cinema.setAddress(resultSet.getString("address"));
        cinema.setPhone(resultSet.getString("phone"));

        schedule.setDate(resultSet.getDate("schedule_date"));
        schedule.setStartTime(resultSet.getString("start_time"));

        ticketType.setAdultTicket(resultSet.getString("adult_ticket"));
        ticketType.setYouthTicket(resultSet.getString("youth_ticket"));
        ticketType.setStudentTicket(resultSet.getString("student_ticket"));

        scheduleInTimeOrder.setSchedule(schedule);
        scheduleInTimeOrder.setCinema(cinema);
        scheduleInTimeOrder.setLanguage(resultSet.getString("movie_lang"));
        scheduleInTimeOrder.setTicketType(ticketType);

        return scheduleInTimeOrder;
    }
}

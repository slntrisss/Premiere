package org.billboard.repository.scheduleSort;

import org.billboard.model.db.Schedule;
import org.billboard.model.scheduleSort.cinema.CinemaSchedule;
import org.billboard.model.scheduleSort.movie.MovieSchedule;
import org.billboard.repository.scheduleSort.mapper.CinemaScheduleMapper;
import org.billboard.repository.scheduleSort.mapper.MovieScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MovieSchedule> getScheduleOrderByTime(int ID){
        String sql = "select c.cinema_name, c.address, c.phone, ch.hall_name, s.start_time, s.schedule_date, " +
                "d.movie_lang, t.adult_ticket, t.youth_ticket, t.student_ticket " +
                "from movie m, cinema c, cinema_hall ch, detail d, schedule s, ticket_type t " +
                "where m.movie_id=d.detail_id " +
                "and m.movie_id=s.movie_id " +
                "and s.schedule_id=t.schedule_id " +
                "and s.cinema_hall_id=ch.cinema_hall_id " +
                "and ch.cinema_id=c.cinema_id " +
                "and m.movie_id=? " +
                "and to_char(sysdate)=to_char(s.schedule_date) " +
                "and util_date.compare_dates(sysdate, util_date.date_to_hours(s.start_time, s.schedule_date)) = -1 " +
                "order by s.start_time";
        return jdbcTemplate.query(sql, new MovieScheduleMapper(), ID);
    }


    public List<MovieSchedule> getScheduleOrderByCinema(int ID){
        String sql = "select c.cinema_name, c.address, c.phone, ch.hall_name, s.start_time, s.schedule_date, " +
                "d.movie_lang, t.adult_ticket, t.youth_ticket, t.student_ticket " +
                "from movie m, cinema c, cinema_hall ch, detail d, schedule s, ticket_type t " +
                "where m.movie_id=d.detail_id " +
                "and m.movie_id=s.movie_id " +
                "and s.schedule_id=t.schedule_id " +
                "and s.cinema_hall_id=ch.cinema_hall_id " +
                "and ch.cinema_id=c.cinema_id " +
                "and m.movie_id=? " +
                "and to_char(sysdate)=to_char(s.schedule_date) " +
                "and util_date.compare_dates(sysdate, util_date.date_to_hours(s.start_time, s.schedule_date)) = -1 " +
                "order by c.cinema_name, s.start_time";
        return jdbcTemplate.query(sql, new MovieScheduleMapper(), ID);
    }

    public List<CinemaSchedule> getScheduleOrderByHall(int ID){
        String sql = "select ch.hall_name, m.movie_name, m.original_name, m.image_file, s.start_time, " +
                "s.schedule_date, d.movie_lang, t.adult_ticket, t.youth_ticket, t.student_ticket " +
                "from movie m, cinema c, cinema_hall ch, detail d, schedule s, ticket_type t " +
                "where m.movie_id=d.detail_id " +
                "and m.movie_id=s.movie_id " +
                "and s.schedule_id=t.schedule_id " +
                "and s.cinema_hall_id=ch.cinema_hall_id " +
                "and ch.cinema_id=c.cinema_id " +
                "and c.cinema_id=? " +
                "and to_char(sysdate)=to_char(s.schedule_date) " +
                "and util_date.compare_dates(sysdate, util_date.date_to_hours(s.start_time, s.schedule_date)) = -1 " +
                "order by ch.hall_name, s.start_time";
        return jdbcTemplate.query(sql, new CinemaScheduleMapper(), ID);
    }

    public List<CinemaSchedule> getScheduleOrderByMovie(int ID){
        String sql = "select ch.hall_name, m.movie_name, m.original_name, m.image_file, s.start_time, " +
                "s.schedule_date, d.movie_lang, t.adult_ticket, t.youth_ticket, t.student_ticket " +
                "from movie m, cinema c, cinema_hall ch, detail d, schedule s, ticket_type t " +
                "where m.movie_id=d.detail_id " +
                "and m.movie_id=s.movie_id " +
                "and s.schedule_id=t.schedule_id " +
                "and s.cinema_hall_id=ch.cinema_hall_id " +
                "and ch.cinema_id=c.cinema_id " +
                "and c.cinema_id=? " +
                "and to_char(sysdate)=to_char(s.schedule_date) " +
                "and util_date.compare_dates(sysdate, util_date.date_to_hours(s.start_time, s.schedule_date)) = -1 " +
                "order by m.movie_name, s.start_time";
        return jdbcTemplate.query(sql, new CinemaScheduleMapper(), ID);
    }

    public void addSchedule(Schedule schedule, int hallId, int movieId){
        String sql = "INSERT INTO schedule " +
                "VALUES(schedule_id_seq.nextval, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, schedule.getDate(), schedule.getStartTime(), hallId,
                movieId);
    }

    public Integer getLastId(){
        String sql = "SELECT max(schedule_id) FROM schedule";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

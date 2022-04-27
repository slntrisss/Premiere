package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.CinemaHall;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallRepository {
    private final JdbcTemplate jdbcTemplate;

    public CinemaHallRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(CinemaHall cinemaHall, int ID){
        String sql = "INSERT INTO cinema_hall VALUES(cinema_hall_is_seq.nextval, ?, ?, ?, ?)";
        jdbcTemplate.update(cinemaHall.getHallName(), ID,
                cinemaHall.getNumberOfCols(), cinemaHall.getNumberOfRows());
    }

    public void update(CinemaHall cinemaHall){
        String sql = "UPDATE cinema_hall SET hall_name=?, "
    }
}

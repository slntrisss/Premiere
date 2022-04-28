package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.CinemaHall;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaHallRepository {
    private final JdbcTemplate jdbcTemplate;

    public CinemaHallRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(CinemaHall cinemaHall, int ID){
        String sql = "BEGIN " +
                "INSERT INTO cinema_hall VALUES(cinema_hall_id_seq.nextval, ?, ?, ?, ?); " +
                "COMMIT; " +
                "END;";
        jdbcTemplate.update(sql, cinemaHall.getHallName(), ID,
                cinemaHall.getNumberOfCols(), cinemaHall.getNumberOfRows());
    }

    public void update(CinemaHall cinemaHall){
        String sql =
                "BEGIN " + " SAVEPOINT before_cinema_delete; " +
                        "    UPDATE cinema_hall SET hall_name=?, number_of_cols=?, number_of_rows=? " +
                        "    WHERE cinema_hall_id=?; " +
                        "    COMMIT; " +
                        "    EXCEPTION " +
                        "    WHEN OTHERS THEN " +
                        "        ROLLBACK TO SAVEPOINT before_cinema_delete; " +
                        "END;";
        jdbcTemplate.update(sql, cinemaHall.getHallName(), cinemaHall.getNumberOfCols(),
                cinemaHall.getNumberOfRows(), cinemaHall.getCinemaHallId());
    }

    public List<CinemaHall> getCinemaHalls(int ID){
        String sql = "SELECT * FROM cinema_hall WHERE cinema_id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CinemaHall.class), ID);
    }

    public void deleteCinemaHallById(int ID){
        String sql =
                "BEGIN " +
                        "SAVEPOINT before_cinema_hall_delete; " +
                "    DELETE FROM cinema_hall " +
                "    WHERE cinema_hall_id=?; " +
                "    COMMIT; " +
                "    EXCEPTION " +
                "    WHEN OTHERS THEN " +
                "        ROLLBACK TO SAVEPOINT before_cinema_hall_delete; " +
                "END;";
        jdbcTemplate.update(sql, ID);
    }
}

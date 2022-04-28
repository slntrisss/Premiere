package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.Cinema;
import org.billboard.model.db.CinemaInfo;
import org.billboard.repository.CrudRepository;
import org.billboard.repository.dao.mapper.CinemaInfoMapper;
import org.billboard.repository.dao.mapper.CinemaMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaRepository implements CrudRepository<CinemaInfo> {

    private final JdbcTemplate jdbcTemplate;

    public CinemaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(CinemaInfo cinema) {
        String sql = "BEGIN " +
                "INSERT INTO cinema VALUES(cinema_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?); " +
                "COMMIT; " +
                "END;";
        jdbcTemplate.update(sql, cinema.getName(), cinema.getAddress(), cinema.getPhone(),
                cinema.getCinemaInfo(), cinema.getNumberOfHalls(), cinema.getStartOfWork(),
                cinema.getEndOfWork(), cinema.getImageFile());
    }

    @Override
    public CinemaInfo findOne(int ID) {
        String sql = "SELECT * FROM cinema WHERE cinema_id=?";
        return jdbcTemplate.queryForObject(sql, new CinemaInfoMapper(), ID);
    }

    @Override
    public List<CinemaInfo> findAll() {
        String sql = "SELECT * FROM cinema";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CinemaInfo.class));
    }

    public List<Cinema> findAllCinemas(){
        String sql = "SELECT cinema_id, cinema_name, address, image_file " +
                "FROM cinema";
        return jdbcTemplate.query(sql, new CinemaMapper());
    }

    public void updateCinema(CinemaInfo cinemaInfo){
        String sql =
                "BEGIN " + " SAVEPOINT before_cinema_delete; " +
                        "    UPDATE cinema SET cinema_name=?, address=?, phone=?, cinema_info=?, " +
                        "    number_of_halls=?, start_of_work=?, end_of_work=?, image_file=? " +
                        "    WHERE cinema_id=?; " +
                        "    COMMIT; " +
                        "    EXCEPTION " +
                        "    WHEN OTHERS THEN " +
                        "        ROLLBACK TO SAVEPOINT before_cinema_delete; " +
                        "END;";
        jdbcTemplate.update(sql, cinemaInfo.getName(), cinemaInfo.getAddress(), cinemaInfo.getPhone(),
                cinemaInfo.getCinemaInfo(), cinemaInfo.getNumberOfHalls(), cinemaInfo.getStartOfWork(),
                cinemaInfo.getEndOfWork(), cinemaInfo.getImageFile(), cinemaInfo.getId());
    }

    @Override
    public boolean exists(int ID) {
        return false;
    }

    @Override
    public void delete(int ID) {
        String sql =
                "BEGIN " + " SAVEPOINT before_cinema_delete; " +
                "    DELETE FROM cinema " +
                "    WHERE cinema_id=?; " +
                "    COMMIT; " +
                "    EXCEPTION " +
                "    WHEN OTHERS THEN " +
                "        ROLLBACK TO SAVEPOINT before_cinema_delete; " +
                "END;";
        jdbcTemplate.update(sql, ID);
    }

    public Integer getLastIndex(){
        String sql = "SELECT max(cinema_id) FROM cinema";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

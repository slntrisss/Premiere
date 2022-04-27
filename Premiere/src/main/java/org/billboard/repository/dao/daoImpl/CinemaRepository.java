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
        String sql = "INSERT INTO cinema VALUES(cinema_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
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

    @Override
    public boolean exists(int ID) {
        return false;
    }

    @Override
    public void delete(int ID) {
        //return 0;
    }

    public Integer getLastIndex(){
        String sql = "SELECT max(cinema_id) FROM cinema";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

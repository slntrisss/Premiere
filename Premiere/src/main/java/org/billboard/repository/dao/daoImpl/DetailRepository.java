package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.Detail;
import org.billboard.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class DetailRepository implements CrudRepository<Detail> {

    private final JdbcTemplate jdbcTemplate;

    public DetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Detail detail) {

    }

    @Override
    public Detail findOne(int ID) {
        String sql = "SELECT * FROM detail WHERE movie_id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Detail.class),ID);
    }

    @Override
    public List<Detail> findAll() {
        String sql = "SELECT * FROM detail";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Detail.class));
    }

    @Override
    public boolean exists(int ID) {
        String sql = "SELECT count(*) FROM detail WHERE movie_id=?";
        return Boolean.TRUE.equals(jdbcTemplate.query(sql, new Object[]{ID}, ResultSet::next));
    }

    @Override
    public void delete(int ID) {
        String sql = "DELETE FROM detail WHERE movie_id=?";
        jdbcTemplate.update(sql);
        //return ID;
    }
}

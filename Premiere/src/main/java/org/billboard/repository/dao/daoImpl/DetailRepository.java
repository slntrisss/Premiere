package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.Detail;
import org.billboard.repository.dao.mapper.DetailMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class DetailRepository {

    private final JdbcTemplate jdbcTemplate;

    public DetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Detail detail, int ID) {
        String sql = "INSERT INTO DETAIL VALUES(detail_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, detail.getCountry(), detail.getLanguage(), detail.getDuration(),
                detail.getReleaseDate(), detail.getAgeRating(), detail.getRating(),
                detail.getNumberOfVotes(), ID, detail.getDescription());
    }


    public Detail findOne(int ID) {
        String sql = "SELECT * FROM detail WHERE movie_id=?";
        return jdbcTemplate.queryForObject(sql, new DetailMapper(),ID);
    }


    public List<Detail> findAll() {
        String sql = "SELECT * FROM detail";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Detail.class));
    }


    public boolean exists(int ID) {
        String sql = "SELECT count(*) FROM detail WHERE movie_id=?";
        return Boolean.TRUE.equals(jdbcTemplate.query(sql, new Object[]{ID}, ResultSet::next));
    }

    public void update(Detail detail){
        String sql = "UPDATE detail SET country=?, movie_lang=?, duration=?, " +
                "release_date=?, age_rating=?, rating=?, number_of_votes=?, description=? " +
                "WHERE detail_id=?";
        jdbcTemplate.update(sql, detail.getCountry(), detail.getLanguage(),
                detail.getDuration(), detail.getReleaseDate(), detail.getAgeRating(),
                detail.getRating(), detail.getNumberOfVotes(), detail.getDescription(),
                detail.getDetailId());
    }


    public void delete(int ID) {
        String sql = "DELETE FROM detail WHERE movie_id=?";
        jdbcTemplate.update(sql);
        //return ID;
    }

    public Integer getLastId(){
        String sql = "SELECT max(detail_id) FROM detail";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

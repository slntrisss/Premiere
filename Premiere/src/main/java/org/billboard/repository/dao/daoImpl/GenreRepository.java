package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.Genre;
import org.billboard.model.db.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class GenreRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int save(Genre genre) {
        return 0;
    }


    public List<MovieGenre> findOne(int ID) {
        String sql = "SELECT  movie_mgmt.get_movie_genre_list(?) as genres from dual;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MovieGenre.class), ID);
    }


    public List<Genre> findAll() {
        String sql = "select * FROM genre";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class));
    }


    public boolean exists(String genre) {
        String sql = "SELECT count(*) FROM genre WHERE genre_type=?";
        return Boolean.TRUE.equals(jdbcTemplate.query(sql, new Object[]{genre}, ResultSet::next));
    }
}

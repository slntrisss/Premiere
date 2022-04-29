package org.billboard.repository.dao.daoImpl;

import org.billboard.model.db.Genre;
import org.billboard.model.db.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GenreRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Genre> getMovieGenreById(int ID){
        String sql = "SELECT G.GENRE_ID, G.GENRE_TYPE FROM GENRE G " +
                "JOIN MOVIE_GENRE MG " +
                "    ON G.GENRE_ID = MG.GENRE_ID " +
                "JOIN MOVIE M " +
                "    ON MG.MOVIE_ID = M.MOVIE_ID " +
                "WHERE M.MOVIE_ID=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class), ID);
    }


    public List<Genre> findAll() {
        String sql = "select * FROM genre";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class));
    }


    public boolean exists(String genre) {
        String sql = "SELECT count(*) FROM genre WHERE genre_type=?";
        return Boolean.TRUE.equals(jdbcTemplate.query(sql, new Object[]{genre}, ResultSet::next));
    }

    public void save(List<Genre> genres, int movieId){
        String sql = "INSERT INTO movie_genre VALUES(?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, movieId);
                preparedStatement.setInt(2, genres.get(i).getGenreId());
            }

            @Override
            public int getBatchSize() {
                return genres.size();
            }
        });
    }

    public void update(List<Genre> genres, int movieId){
        String proc_call = "call DB.update_movie_genre(?, ?)";
        jdbcTemplate.batchUpdate(proc_call, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, movieId);
                preparedStatement.setInt(2, genres.get(i).getGenreId());
            }

            @Override
            public int getBatchSize() {
                return genres.size();
            }
        });
    }

    public void delete(int movieId, int genreId){
        String sql = "DELETE FROM movie_genre WHERE movie_id=? AND genre_id=?";
        jdbcTemplate.update(sql, movieId, genreId);
    }
}

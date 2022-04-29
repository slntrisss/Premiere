package org.billboard.repository.dao.mapper;

import org.billboard.model.db.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(resultSet.getInt("movie_id"));
        movie.setMovieName(resultSet.getString("movie_name"));
        movie.setOriginalName(resultSet.getString("original_name"));
        return movie;
    }
}

package org.billboard.repository.dao.mapper;

import org.billboard.model.db.Detail;
import org.billboard.model.db.Movie;
import org.billboard.model.db.MovieGenre;
import org.billboard.model.detail.MovieInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDetailMapper implements RowMapper<MovieInfo> {
    @Override
    public MovieInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieInfo movieDetail = new MovieInfo();
        Movie movie = new Movie();
        Detail detail = new Detail();
        MovieGenre movieGenre = new MovieGenre();


        movie.setMovieId(resultSet.getInt("movie_id"));
        movie.setMovieName(resultSet.getString("movie_name"));
        movie.setOriginalName(resultSet.getString("original_name"));

        detail.setCountry(resultSet.getString("country"));
        detail.setAgeRating(resultSet.getInt("age_rating"));
        detail.setDescription(resultSet.getString("description"));
        detail.setRating(resultSet.getInt("rating"));
        detail.setNumberOfVotes(resultSet.getInt("number_of_votes"));
        detail.setDuration(resultSet.getInt("duration"));
        detail.setReleaseDate(resultSet.getDate("release_date"));
        detail.setLanguage(resultSet.getString("movie_lang"));

        movieDetail.setGenres(resultSet.getString("genre_list"));

        movieDetail.setMovie(movie);
        movieDetail.setDetail(detail);
        movieDetail.setActors(resultSet.getString("actors"));
        movieDetail.setDirectors(resultSet.getString("directors"));
        return movieDetail;
    }
}

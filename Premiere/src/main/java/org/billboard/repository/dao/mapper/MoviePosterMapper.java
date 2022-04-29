package org.billboard.repository.dao.mapper;


import org.billboard.model.poster.MoviePoster;
import org.springframework.jdbc.core.RowMapper;
import org.billboard.service.imageProcessor.BlobService;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoviePosterMapper implements RowMapper<MoviePoster> {
    @Override
    public MoviePoster mapRow(ResultSet resultSet, int i) throws SQLException {
        MoviePoster moviePoster = new MoviePoster();
        moviePoster.setMovieName(resultSet.getString("movie_name"));
        moviePoster.setReleaseDate(resultSet.getDate("release_date"));
        moviePoster.setGenre(resultSet.getString("genre_list"));
        moviePoster.setMovieId(resultSet.getInt("movie_id"));
        //Blob blob = resultSet.getBlob("image_file");
        //moviePoster.setMoviePoster(BlobService.encodeImage(blob));
        return moviePoster;
    }
}

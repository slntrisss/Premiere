package org.billboard.repository.dao.daoImpl;
import org.billboard.model.db.Movie;
import org.billboard.model.detail.MovieInfo;
import org.billboard.model.poster.MoviePoster;
import org.billboard.repository.CrudRepository;
import org.billboard.repository.dao.mapper.MovieDetailMapper;
import org.billboard.repository.dao.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.billboard.repository.dao.mapper.MoviePosterMapper;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class MovieRepository implements CrudRepository<Movie> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(Movie movie) {
        String sql = "INSERT INTO MOVIE VALUES(movie_id_seq.nextval, ?, ?, ?) ";
        jdbcTemplate.update(sql, movie.getMovieName(), movie.getOriginalName(), movie.getImageFile());
    }

    @Override
    public Movie findOne(int ID) {
        String sql = "SELECT * FROM movie " +
                "WHERE movie_id=?";
        return jdbcTemplate.queryForObject(sql, new MovieMapper(), ID);
    }

    public MovieInfo findMovieDetails(int ID){
        String sql = "SELECT m.movie_id, m.image_file, m.movie_name, m.original_name, " +
                "movie_mgmt.get_movie_genre_list(m.movie_id) as genre_list, " +
                "d.rating, d.number_of_votes, d.description, d.country, d.release_date, d.movie_lang, " +
                "d.age_rating, d.duration, movie_mgmt.get_directors(d.detail_id) as directors, " +
                "movie_mgmt.get_actors(d.detail_id) as actors " +
                "FROM movie m " +
                "JOIN detail d " +
                "ON d.movie_id=m.movie_id " +
                "WHERE m.movie_id=?";
        return jdbcTemplate.queryForObject(sql, new MovieDetailMapper(), ID);
    }

    @Override
    public List<Movie> findAll() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, new MovieMapper());
    }

    public List<Movie> getMoviesRollingToday() {
        String sql = "select m.MOVIE_ID, m.MOVIE_NAME, m.ORIGINAL_NAME " +
                "from MOVIE m, DETAIL d " +
                "where d.RELEASE_DATE <=sysdate " +
                "and m.MOVIE_ID=d.MOVIE_ID";
        return jdbcTemplate.query(sql, new MovieMapper());
    }

    public List<MoviePoster> findAllMovies(){
        String sql = "SELECT m.image_file, m.movie_id, m.movie_name, d.release_date, " +
                "movie_mgmt.get_movie_genre_list(m.movie_id) " +
                "as genre_list " +
                "FROM movie m, detail d " +
                "WHERE d.movie_id=m.movie_id " +
                "AND sysdate>=d.release_date";
        return jdbcTemplate.query(sql, new MoviePosterMapper());
    }

    public List<MoviePoster> findToBeSoonReleasedMovies(){
        String sql = "SELECT m.image_file, m.movie_name, d.release_date, " +
                "movie_mgmt.get_movie_genre_list(m.movie_id) as genre_list " +
                "FROM movie m, detail d " +
                "WHERE d.movie_id=m.movie_id " +
                "AND sysdate<d.release_date";
        return jdbcTemplate.query(sql, new MoviePosterMapper());
    }

    public List<MoviePoster> findMoviesForKids(){
        String sql = "select m.image_file, m.movie_id, m.movie_name, d.release_date, " +
                "get_movie_genre_list(m.movie_id) as genre_list " +
                "from movie m, detail d, genre g, movie_genre mg " +
                "where m.movie_id=mg.movie_id " +
                "and mg.genre_id=g.genre_id " +
                "and d.movie_id=m.movie_id " +
                "and genre_type IN ('cartoon') " +
                "and sysdate>=d.release_date";
        return jdbcTemplate.query(sql, new MoviePosterMapper());
    }

    @Override
    public boolean exists(int ID) {
        String sql = "SELECT count(*) FROM movie WHERE movie_id=?";
        return Boolean.TRUE.equals(jdbcTemplate.query(sql, new Object[]{ID}, ResultSet::next));
    }

    public void update(Movie movie){
        String sql = "UPDATE movie SET movie_name=?, original_name=?, image_file=? " +
                "WHERE movie_id=?";
        jdbcTemplate.update(sql, movie.getMovieName(), movie.getOriginalName(),
                movie.getImageFile(), movie.getMovieId());
    }
    @Override
    public void delete(int ID) {
        String deleteSql = "DELETE FROM movie WHERE movie_id=?";
        jdbcTemplate.update(deleteSql, ID);
    }

    public Integer getLastId(){
        String sql = "SELECT max(movie_id) FROM movie";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

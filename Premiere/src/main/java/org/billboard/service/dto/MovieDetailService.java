package org.billboard.service.dto;

import org.billboard.model.db.*;
import org.billboard.model.dto.MovieDetail;
import org.billboard.model.poster.MoviePoster;
import org.billboard.repository.dao.daoImpl.DetailRepository;
import org.billboard.repository.dao.daoImpl.RoleDetailRepository;
import org.billboard.service.dao.GenreService;
import org.billboard.service.dao.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MovieDetailService {
    private final MovieService movieService;
    private final DetailRepository detailRepository;
    private final RoleDetailRepository roleDetailRepository;
    private final GenreService genreService;

    @Autowired
    public MovieDetailService(MovieService movieService,
                              DetailRepository detailRepository,
                              RoleDetailRepository roleDetailRepository,
                              GenreService genreService) {
        this.movieService = movieService;
        this.detailRepository = detailRepository;
        this.roleDetailRepository = roleDetailRepository;
        this.genreService = genreService;
    }

    public MovieDetail getMovieDetails(int ID){
        MovieDetail movieDetail = new MovieDetail();

        Movie movie = movieService.findOne(ID);
        Detail detail = detailRepository.findOne(ID);
        List<RoleDetail> roleDetails = roleDetailRepository.findRoleDetails(detail.getDetailId());
        MovieGenre movieGenre = new MovieGenre();
        movieGenre.setGenres(genreService.getGenresById(ID));

        System.out.println(detail.getReleaseDate());

        movieDetail.setMovie(movie);
        movieDetail.setRoleDetails(roleDetails);
        movieDetail.setDetail(detail);
        movieDetail.setGenres(movieGenre);
        return movieDetail;
    }

    public List<MoviePoster> getMoviePosters(){
        return movieService.getAllMovies();
    }

    public List<Genre> getGenreList(){
        return genreService.getGenreList();
    }

    @Transactional
    public void save(MovieDetail movieDetail){
        Movie movie = movieDetail.getMovie();
        Detail detail = movieDetail.getDetail();
        List<RoleDetail> roleDetails = movieDetail.getRoleDetails();
        List<Genre> genres = movieDetail.getGenres().getGenres();

        movieService.save(movie);
        movie.setMovieId(movieService.getLasId());
        detailRepository.save(detail, movie.getMovieId());
        detail.setDetailId(detailRepository.getLastId());
        roleDetailRepository.save(roleDetails, detail.getDetailId());
        genreService.save(genres, movie.getMovieId());
    }

    @Transactional
    public void update(MovieDetail movieDetail){
        Movie movie = movieDetail.getMovie();
        Detail detail = movieDetail.getDetail();
        List<RoleDetail> roleDetails = movieDetail.getRoleDetails();
        List<Genre> genres = movieDetail.getGenres().getGenres();

        movieService.update(movie);
        detailRepository.update(detail);
        roleDetailRepository.update(roleDetails, detail.getDetailId());
        genreService.update(genres, movie.getMovieId());
    }

    @Transactional
    public void deleteMovieById(int ID){
        movieService.deleteMovieById(ID);
    }

    @Transactional
    public void deleteRoleDetailById(int ID){
        roleDetailRepository.delete(ID);
    }

    @Transactional
    public void deleteGenreById(int movieId, int genreId){
        genreService.deleteGenreById(movieId, genreId);
    }
}

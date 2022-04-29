package org.billboard.service.dao;

import org.billboard.model.db.Genre;
import org.billboard.repository.dao.daoImpl.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenresById(int ID){
        return genreRepository.getMovieGenreById(ID);
    }

    public List<Genre> getGenreList(){
        return genreRepository.findAll();
    }

    public void save(List<Genre> genres, int ID){
        genreRepository.save(genres, ID);
    }

    public void update(List<Genre> genres, int movieID){
        genreRepository.update(genres, movieID);
    }

    public void deleteGenreById(int movieId, int genreId){
        genreRepository.delete(movieId, genreId);
    }
}

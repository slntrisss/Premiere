package org.billboard.service.dao;

import org.billboard.model.db.CinemaHall;
import org.billboard.repository.dao.daoImpl.CinemaHallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    public CinemaHallService(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    public void deleteCinemaHallById(int ID){
        cinemaHallRepository.deleteCinemaHallById(ID);
    }
    public List<CinemaHall> getCinemaHalls(int ID){
        return cinemaHallRepository.getCinemaHalls(ID);
    }
    public void updateCinemaHall(CinemaHall cinemaHall){
        cinemaHallRepository.update(cinemaHall);
    }

    public void save(CinemaHall cinemaHall, int ID){
        cinemaHallRepository.save(cinemaHall, ID);
    }
}

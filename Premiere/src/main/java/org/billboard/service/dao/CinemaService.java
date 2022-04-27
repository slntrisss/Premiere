package org.billboard.service.dao;

import org.billboard.model.db.Cinema;
import org.billboard.model.db.CinemaHall;
import org.billboard.model.db.CinemaInfo;
import org.billboard.model.dto.CinemaDetail;
import org.billboard.repository.dao.daoImpl.CinemaHallRepository;
import org.billboard.repository.dao.daoImpl.CinemaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;
    private final CinemaHallRepository cinemaHallRepository;

    public CinemaService(CinemaRepository cinemaRepository,
                         CinemaHallRepository cinemaHallRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    public List<Cinema> getAllCinemas(){
        return cinemaRepository.findAllCinemas();
    }

    public CinemaInfo getCinemaById(int ID){
        return cinemaRepository.findOne(ID);
    }

}

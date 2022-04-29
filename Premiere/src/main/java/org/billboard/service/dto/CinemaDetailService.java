package org.billboard.service.dto;

import org.billboard.model.db.Cinema;
import org.billboard.model.db.CinemaHall;
import org.billboard.model.db.CinemaInfo;
import org.billboard.model.dto.CinemaDetail;
import org.billboard.service.dao.CinemaHallService;
import org.billboard.service.dao.CinemaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaDetailService {
    private final CinemaService cinemaService;
    private final CinemaHallService cinemaHallService;

    public CinemaDetailService(CinemaService cinemaService, CinemaHallService cinemaHallService) {
        this.cinemaService = cinemaService;
        this.cinemaHallService = cinemaHallService;
    }

    public void deleteCinemaHallById(int ID){
        cinemaHallService.deleteCinemaHallById(ID);
    }

    public List<Cinema> getAllCinemas(){
        return cinemaService.getAllCinemas();
    }

    public CinemaDetail getCinemaDetails(int ID){
        CinemaInfo cinemaInfo = cinemaService.getCinemaById(ID);
        List<CinemaHall> cinemaHalls = cinemaHallService.getCinemaHalls(ID);
        CinemaDetail cinemaDetail = new CinemaDetail();

        cinemaDetail.setCinemaInfo(cinemaInfo);
        cinemaDetail.setCinemaHalls(cinemaHalls);

        return cinemaDetail;
    }

    @Transactional
    public void save(CinemaDetail cinemaDetail){
        CinemaInfo cinemaInfo = cinemaDetail.getCinemaInfo();
        List<CinemaHall> cinemaHalls = cinemaDetail.getCinemaHalls();
        cinemaService.save(cinemaInfo);
        cinemaInfo.setId(cinemaService.getLasId());
        for(CinemaHall cinemaHall: cinemaHalls){
            cinemaHallService.save(cinemaHall, cinemaInfo.getId());
        }
    }

    @Transactional
    public void update(CinemaDetail cinemaDetail){
        CinemaInfo cinemaInfo = cinemaDetail.getCinemaInfo();
        List<CinemaHall> cinemaHalls = cinemaDetail.getCinemaHalls();
        cinemaService.update(cinemaInfo);
        for(CinemaHall cinemaHall: cinemaHalls){
            cinemaHallService.updateCinemaHall(cinemaHall);
        }
    }

    @Transactional
    public void deleteCinema(int ID){
        cinemaService.delete(ID);
    }
}

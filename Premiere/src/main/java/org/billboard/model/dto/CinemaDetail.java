package org.billboard.model.dto;

import org.billboard.model.db.CinemaHall;
import org.billboard.model.db.CinemaInfo;

import java.util.ArrayList;
import java.util.List;

public class CinemaDetail {
    private CinemaInfo cinemaInfo;
    private List<CinemaHall> cinemaHalls;

    public CinemaDetail() {
    }

    public CinemaDetail(CinemaInfo cinemaInfo, List<CinemaHall> cinemaHalls) {
        this.cinemaInfo = cinemaInfo;
        this.cinemaHalls = cinemaHalls;
    }

    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

    public void setCinemaHalls(List<CinemaHall> cinemaHalls) {
        this.cinemaHalls = cinemaHalls;
    }
}

package org.billboard.model.db;

public class CinemaHall {
    private int cinemaHallId;
    private String hallName;
    private int numberOfCols;
    private int numberOfRows;

    public CinemaHall() {
    }

    public CinemaHall(int cinemaHallId, String hallName, int numberOfCols, int numberOfRows) {
        this.cinemaHallId = cinemaHallId;
        this.hallName = hallName;
        this.numberOfCols = numberOfCols;
        this.numberOfRows = numberOfRows;
    }

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getNumberOfCols() {
        return numberOfCols;
    }

    public void setNumberOfCols(int numberOfCols) {
        this.numberOfCols = numberOfCols;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
}

package org.billboard.model.dto;

import java.util.List;

public class CinemaDetail {
    private int cinema_id;
    private String cinemaName;
    private String address;
    private String phone;
    private String cinemaInfo;
    private int numberOfHalls;
    private String startOfWork;
    private String endOfWork;
    private String imageFile;
    private List<String> hallNames;
    private List<Integer> numberOfCols;
    private List<Integer> numberOfRows;

    public CinemaDetail() {
    }

    public CinemaDetail(int cinema_id, String cinemaName, String address,
                        String phone, String cinemaInfo, int numberOfHalls,
                        String startOfWork, String endOfWork, String imageFile,
                        List<String> hallNames, List<Integer> numberOfCols,
                        List<Integer> numberOfRows) {
        this.cinema_id = cinema_id;
        this.cinemaName = cinemaName;
        this.address = address;
        this.phone = phone;
        this.cinemaInfo = cinemaInfo;
        this.numberOfHalls = numberOfHalls;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
        this.imageFile = imageFile;
        this.hallNames = hallNames;
        this.numberOfCols = numberOfCols;
        this.numberOfRows = numberOfRows;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(String cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public int getNumberOfHalls() {
        return numberOfHalls;
    }

    public void setNumberOfHalls(int numberOfHalls) {
        this.numberOfHalls = numberOfHalls;
    }

    public String getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(String startOfWork) {
        this.startOfWork = startOfWork;
    }

    public String getEndOfWork() {
        return endOfWork;
    }

    public void setEndOfWork(String endOfWork) {
        this.endOfWork = endOfWork;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public List<String> getHallNames() {
        return hallNames;
    }

    public void setHallNames(List<String> hallNames) {
        this.hallNames = hallNames;
    }

    public List<Integer> getNumberOfCols() {
        return numberOfCols;
    }

    public void setNumberOfCols(List<Integer> numberOfCols) {
        this.numberOfCols = numberOfCols;
    }

    public List<Integer> getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(List<Integer> numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
}

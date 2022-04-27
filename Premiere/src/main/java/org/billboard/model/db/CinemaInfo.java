package org.billboard.model.db;

import java.io.Serializable;

public class CinemaInfo extends Cinema implements Serializable {
    private String phone;
    private String cinemaInfo;
    private int numberOfHalls;
    private String startOfWork;
    private String endOfWork;

    public CinemaInfo() {
    }

    public CinemaInfo(int id, String name, String address, String imageFile,
                      String phone, String cinemaInfo, int numberOfHalls,
                      String startOfWork, String endOfWork) {
        super(id, name, address, imageFile);
        this.phone = phone;
        this.cinemaInfo = cinemaInfo;
        this.numberOfHalls = numberOfHalls;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getAddress() {
        return super.getAddress();
    }

    public void setAddress(String address) {
        super.setAddress(address);
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
        return super.getImageFile();
    }

    public void setImageFile(String imageFile) {
        super.setImageFile(imageFile);
    }
}


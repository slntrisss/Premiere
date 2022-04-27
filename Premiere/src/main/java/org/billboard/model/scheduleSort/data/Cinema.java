package org.billboard.model.scheduleSort.data;

public class Cinema {
    private String name;
    private String hallName;
    private String address;
    private String phone;

    public Cinema() {
    }

    public Cinema(String name, String hallName, String address, String phone) {
        this.name = name;
        this.hallName = hallName;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
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
}

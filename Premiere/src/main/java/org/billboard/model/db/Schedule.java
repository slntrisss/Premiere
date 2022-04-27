package org.billboard.model.db;

import java.util.Date;

public class Schedule {
    private Date date;
    private String startTime;

    public Schedule() {
    }

    public Schedule(Date date, String startTime) {
        this.date = date;
        this.startTime = startTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}

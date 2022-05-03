package org.billboard.model.db;

import java.util.Date;

public class Schedule {
    private int scheduleId;
    private Date date;
    private String startTime;

    public Schedule() {
    }

    public Schedule(int scheduleId, Date date, String startTime) {
        this.scheduleId = scheduleId;
        this.date = date;
        this.startTime = startTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
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

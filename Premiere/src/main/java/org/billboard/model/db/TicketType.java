package org.billboard.model.db;

public class TicketType {
    private String adultTicket;
    private String youthTicket;
    private String studentTicket;

    public TicketType() {
    }

    public TicketType(String adultTicket, String youthTicket, String studentTicket) {
        this.adultTicket = adultTicket;
        this.youthTicket = youthTicket;
        this.studentTicket = studentTicket;
    }

    public String getAdultTicket() {
        return adultTicket;
    }

    public void setAdultTicket(String adultTicket) {
        this.adultTicket = adultTicket;
    }

    public String getYouthTicket() {
        return youthTicket;
    }

    public void setYouthTicket(String youthTicket) {
        this.youthTicket = youthTicket;
    }

    public String getStudentTicket() {
        return studentTicket;
    }

    public void setStudentTicket(String studentTicket) {
        this.studentTicket = studentTicket;
    }
}

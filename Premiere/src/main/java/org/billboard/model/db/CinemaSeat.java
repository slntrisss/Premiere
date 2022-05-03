package org.billboard.model.db;

public class CinemaSeat {
    private int cinemaSeatId;
    private int reservedSeatNumber;
    private int reservedRowNumber;
    private String ticketType;

    public CinemaSeat() {
    }

    public CinemaSeat(int cinemaSeatId, int reservedSeatNumber, int reservedRowNumber, String ticketType) {
        this.cinemaSeatId = cinemaSeatId;
        this.reservedSeatNumber = reservedSeatNumber;
        this.reservedRowNumber = reservedRowNumber;
        this.ticketType = ticketType;
    }

    public int getCinemaSeatId() {
        return cinemaSeatId;
    }

    public void setCinemaSeatId(int cinemaSeatId) {
        this.cinemaSeatId = cinemaSeatId;
    }

    public int getReservedSeatNumber() {
        return reservedSeatNumber;
    }

    public void setReservedSeatNumber(int reservedSeatNumber) {
        this.reservedSeatNumber = reservedSeatNumber;
    }

    public int getReservedRowNumber() {
        return reservedRowNumber;
    }

    public void setReservedRowNumber(int reservedRowNumber) {
        this.reservedRowNumber = reservedRowNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}

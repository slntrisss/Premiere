package org.billboard.model.db;

import java.util.Date;

public class Booking {
    private Date paymentDate;
    private int price;

    public Booking() {
    }

    public Booking(Date paymentDate, int price) {
        this.paymentDate = paymentDate;
        this.price = price;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

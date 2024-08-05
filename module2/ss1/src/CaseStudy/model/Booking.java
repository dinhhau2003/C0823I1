package CaseStudy.model;

import java.util.Date;

public class Booking {
    private int maBooking;
    private Date book;
    private Date checkIn;
    private Date checkOut;
    private int maKH;
    private int maDV;

    public Booking() {
    }

    public Booking(int maBooking, Date book, Date checkIn, Date checkOut, int maKH, int maDV) {
        this.maBooking = maBooking;
        this.book = book;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.maKH = maKH;
        this.maDV = maDV;
    }

    public int getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(int maBooking) {
        this.maBooking = maBooking;
    }

    public Date getBook() {
        return book;
    }

    public void setBook(Date book) {
        this.book = book;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking=" + maBooking +
                ", book=" + book +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", maKH=" + maKH +
                ", maDV=" + maDV +
                '}';
    }
}

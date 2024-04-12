package com.example.quanlyphongtro.model;

//import java.util.Date;
import java.sql.Date;

public class Room {
    private int id;
    private String name;
    private String phone;
    Date day;
    private int idThanhToan;
    private String tenThanhToan;

    public Room() {
    }

    public Room(int id, String name, String phone, Date day, int idThanhToan) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.idThanhToan = idThanhToan;
    }

    public Room(int id, String name, String phone, Date day,String tenThanhToan) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.tenThanhToan=tenThanhToan;
    }

    public Room(String name, String phone, Date day, int idThanhToan) {
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.idThanhToan = idThanhToan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(int idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getTenThanhToan() {
        return tenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }
}

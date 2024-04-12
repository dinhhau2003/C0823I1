package com.example.quanlyphongtro.model;

public class Pay {
    private int id;
    private String tenThanhToan;

    public Pay() {
    }

    public Pay(int id, String tenThanhToan) {
        this.id = id;
        this.tenThanhToan = tenThanhToan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThanhToan() {
        return tenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }
}

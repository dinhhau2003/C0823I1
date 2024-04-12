package com.example.hanghoa.model;

public class LoaiHang {
    private int maLoaiHang;
    private String tenLoaiHang;

    public LoaiHang() {
    }

    public LoaiHang(int maLoaiHang, String tenLoaiHang) {
        this.maLoaiHang = maLoaiHang;
        this.tenLoaiHang = tenLoaiHang;
    }

    public int getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(int maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public String getTenLoaiHang() {
        return tenLoaiHang;
    }

    public void setTenLoaiHang(String tenLoaiHang) {
        this.tenLoaiHang = tenLoaiHang;
    }
}

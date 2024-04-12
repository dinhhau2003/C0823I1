package com.example.khach_san.model;

import java.sql.Date;

public class KhachHang {
    private int maKhachHang;
    private int maLoaiKhach;
    private String hoTen;
    Date day;
    private boolean gioiTinh;
    private String soCMND;
    private String tenLoaiKhach;

    public KhachHang() {
    }

    public KhachHang(int maKhachHang, int maLoaiKhach, String hoTen, Date day, boolean gioiTinh, String soCMND) {
        this.maKhachHang = maKhachHang;
        this.maLoaiKhach = maLoaiKhach;
        this.hoTen = hoTen;
        this.day = day;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
    }

    public KhachHang(int maKhachHang, String hoTen, Date day, boolean gioiTinh, String soCMND, String tenLoaiKhach) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.day = day;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.tenLoaiKhach = tenLoaiKhach;
    }

    public KhachHang(int maLoaiKhach, String hoTen, Date day, boolean gioiTinh, String soCMND) {
        this.maLoaiKhach = maLoaiKhach;
        this.hoTen = hoTen;
        this.day = day;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaLoaiKhach() {
        return maLoaiKhach;
    }

    public void setMaLoaiKhach(int maLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getTenLoaiKhach() {
        return tenLoaiKhach;
    }

    public void setTenLoaiKhach(String tenLoaiKhach) {
        this.tenLoaiKhach = tenLoaiKhach;
    }
}

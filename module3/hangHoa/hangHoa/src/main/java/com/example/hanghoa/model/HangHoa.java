package com.example.hanghoa.model;

import java.sql.Date;

public class HangHoa {
  private int maHangHoa;
  private String tenHangHoa;
  private String donViTinh;
  private Double gia;
  Date day;
  private int maLoaiHang;
  private String tenLoaiHang;

    public HangHoa() {
    }

    public HangHoa(int maHangHoa, String tenHangHoa, String donViTinh, Double gia, Date day, int maLoaiHang) {
        this.maHangHoa = maHangHoa;
        this.tenHangHoa = tenHangHoa;
        this.donViTinh = donViTinh;
        this.gia = gia;
        this.day = day;
        this.maLoaiHang = maLoaiHang;
    }

    public HangHoa(String tenHangHoa, String donViTinh, Double gia, Date day, int maLoaiHang) {
        this.tenHangHoa = tenHangHoa;
        this.donViTinh = donViTinh;
        this.gia = gia;
        this.day = day;
        this.maLoaiHang = maLoaiHang;
    }

    public HangHoa(int maHangHoa, String tenHangHoa, String donViTinh, Double gia, Date day, String tenLoaiHang) {
        this.maHangHoa = maHangHoa;
        this.tenHangHoa = tenHangHoa;
        this.donViTinh = donViTinh;
        this.gia = gia;
        this.day = day;
        this.tenLoaiHang = tenLoaiHang;
    }

    public int getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(int maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
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

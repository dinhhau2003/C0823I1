package com.example.benh_an.model;

import java.sql.Date;

public class BenhAn {
    private int id;
    private int maBenhNhan;
    private int maBenhAn;
    Date dayNhapVien;
    Date dayXuatVien;
    private String lyDoNhapVien;
    private String tenBenhNhan;

    public BenhAn() {
    }

    public BenhAn(int maBenhAn,int maBenhNhan,  Date dayNhapVien, Date dayXuatVien, String lyDoNhapVien) {
        this.maBenhNhan = maBenhNhan;
        this.maBenhAn = maBenhAn;
        this.dayNhapVien = dayNhapVien;
        this.dayXuatVien = dayXuatVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public BenhAn(int id, int maBenhNhan, int maBenhAn, Date dayNhapVien, Date dayXuatVien, String lyDoNhapVien, String tenBenhNhan) {
        this.id = id;
        this.maBenhNhan = maBenhNhan;
        this.maBenhAn = maBenhAn;
        this.dayNhapVien = dayNhapVien;
        this.dayXuatVien = dayXuatVien;
        this.lyDoNhapVien = lyDoNhapVien;
        this.tenBenhNhan = tenBenhNhan;
    }

    public BenhAn(int id, int maBenhAn, Date dayNhapVien, Date dayXuatVien, String lyDoNhapVien, String tenBenhNhan) {
        this.id = id;
        this.maBenhAn = maBenhAn;
        this.dayNhapVien = dayNhapVien;
        this.dayXuatVien = dayXuatVien;
        this.lyDoNhapVien = lyDoNhapVien;
        this.tenBenhNhan = tenBenhNhan;
    }

    public BenhAn(int id, int maBenhNhan, int maBenhAn, Date dayNhapVien, Date dayXuatVien, String lyDoNhapVien) {
        this.id = id;
        this.maBenhNhan = maBenhNhan;
        this.maBenhAn = maBenhAn;
        this.dayNhapVien = dayNhapVien;
        this.dayXuatVien = dayXuatVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public int getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(int maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public Date getDayNhapVien() {
        return dayNhapVien;
    }

    public void setDayNhapVien(Date dayNhapVien) {
        this.dayNhapVien = dayNhapVien;
    }

    public Date getDayXuatVien() {
        return dayXuatVien;
    }

    public void setDayXuatVien(Date dayXuatVien) {
        this.dayXuatVien = dayXuatVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }
}

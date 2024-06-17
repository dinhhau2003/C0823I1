package com.example.benh_an.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BenhAn {
    @Id
    private String maBenhAn;
    private String tenBenhNhan;
    private LocalDate ngayNhapVien;
    private LocalDate ngayRaVien;
    private String lyDoNhapVien;
    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private BenhNhan benhNhan;

    public BenhAn() {
    }

    public BenhAn(String maBenhAn, String tenBenhNhan, LocalDate ngayNhapVien, LocalDate ngayRaVien, String lyDoNhapVien, BenhNhan benhNhan) {
        this.maBenhAn = maBenhAn;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
        this.benhNhan = benhNhan;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public LocalDate getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(LocalDate ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public LocalDate getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(LocalDate ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }
}

package org.arthur.exam_module_4.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maDuAn;
    @ManyToOne
    @JoinColumn(name = "doanh_nghiep_id")
    private DoanhNghiep doanhNghiep;
    private String tenDuAn;
    private Double kinhPhi;
    private String moTa;
    private Date ngayDangKy;
    private double thoiGianDangKy;
    private Double chiPhi;
    private boolean active = true;

    public DuAn() {
    }

    public DuAn(Long id, String maDuAn, DoanhNghiep doanhNghiep, String tenDuAn, Double kinhPhi, String moTa, Date ngayDangKy, double thoiGianDangKy, Double chiPhi, boolean active) {
        this.id = id;
        this.maDuAn = maDuAn;
        this.doanhNghiep = doanhNghiep;
        this.tenDuAn = tenDuAn;
        this.kinhPhi = kinhPhi;
        this.moTa = moTa;
        this.ngayDangKy = ngayDangKy;
        this.thoiGianDangKy = thoiGianDangKy;
        this.chiPhi = chiPhi;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public Double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(Double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public double getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(double thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public Double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(Double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
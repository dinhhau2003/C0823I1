package com.example.duan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class DuAn {
    @Id
    @NotBlank
    @Pattern(regexp = "[D][A][-]*(\\d{4})",message = "Sai định dạng, Định dạng đúng là DA-XXXX")
    private String maDuAn;
    @NotBlank
    private String tenDuAn;
    @ManyToOne
    @JoinColumn(name = "idDoanhNghiep",referencedColumnName = "idDoanhNghiep")
    @NotNull(message = "không được để trống")
    private DoanhNghiep doanhNghiep;
    @NotNull
    private Double kinhPhi;
    private String moTa;
//    @Size(min = 1, max=100, message = "Vui lòng nhập nhỏ hơn 100 và lơn hơn 1")
    @DecimalMin(value = "1",message = "không được âm")
    @Min(value = 1, message = "Thời gian đăng ký giới thiệu là 1-12 tháng ")
    @Max(value = 12, message = "Thời gian đăng ký giới thiệu là 1-12 tháng ")
    private Double thoiGianDangKy;
    @PastOrPresent(message = "ngày nhập không được lớn hơn ngày hiện tại")

    private LocalDate ngayDangKy;

    public DuAn() {
    }

    public DuAn(String maDuAn, String tenDuAn, DoanhNghiep doanhNghiep, Double kinhPhi, String moTa, Double thoiGianDangKy, LocalDate ngayDangKy) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.doanhNghiep = doanhNghiep;
        this.kinhPhi = kinhPhi;
        this.moTa = moTa;
        this.thoiGianDangKy = thoiGianDangKy;
        this.ngayDangKy = ngayDangKy;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
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

    public Double getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(Double thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
}

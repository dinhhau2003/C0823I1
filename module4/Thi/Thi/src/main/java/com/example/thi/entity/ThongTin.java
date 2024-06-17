package com.example.thi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class ThongTin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "không được để trống")
    private String tieuDe;
    @NotNull(message = "Không được để trống")
    private LocalDate timeStart;
    @NotNull(message = "Không được để trống")
    private LocalDate timeEnd;
    @DecimalMin(value = "10000", message = "phải lớn hơn 10000")
    @NotNull(message = "Không được để trống")
//    @Min(10000)
    private Double mucGiamGia;
    @NotEmpty(message = "không được để trống")
    private String chiTiet;


    public ThongTin() {
    }

    public ThongTin(Long id, String tieuDe, LocalDate timeStart, LocalDate timeEnd, Double mucGiamGia, String chiTiet) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public LocalDate getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDate timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDate getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDate timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Double getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(Double mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}

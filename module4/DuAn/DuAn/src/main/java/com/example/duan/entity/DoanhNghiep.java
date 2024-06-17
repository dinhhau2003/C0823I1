package com.example.duan.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDoanhNghiep;
    private String tenDoanhNghiep;
    private String linhVucKinhDoanh;
    private String soDienThoai;
    private String email;
    private String diaCHi;
    @OneToMany(mappedBy = "doanhNghiep",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<DuAn> duAns;

    public DoanhNghiep() {
    }

    public DoanhNghiep(Integer idDoanhNghiep, String tenDoanhNghiep, String linhVucKinhDoanh, String soDienThoai, String email, String diaCHi, Set<DuAn> duAns) {
        this.idDoanhNghiep = idDoanhNghiep;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.linhVucKinhDoanh = linhVucKinhDoanh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaCHi = diaCHi;
        this.duAns = duAns;
    }

    public Integer getIdDoanhNghiep() {
        return idDoanhNghiep;
    }

    public void setIdDoanhNghiep(Integer idDoanhNghiep) {
        this.idDoanhNghiep = idDoanhNghiep;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getLinhVucKinhDoanh() {
        return linhVucKinhDoanh;
    }

    public void setLinhVucKinhDoanh(String linhVucKinhDoanh) {
        this.linhVucKinhDoanh = linhVucKinhDoanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaCHi() {
        return diaCHi;
    }

    public void setDiaCHi(String diaCHi) {
        this.diaCHi = diaCHi;
    }

    public Set<DuAn> getDuAns() {
        return duAns;
    }

    public void setDuAns(Set<DuAn> duAns) {
        this.duAns = duAns;
    }
}

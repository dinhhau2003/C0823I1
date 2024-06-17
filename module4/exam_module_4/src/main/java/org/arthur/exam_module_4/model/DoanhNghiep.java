package org.arthur.exam_module_4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String linhVucKinhDoanh;
    private String soDienThoai;
    private String email;

    public DoanhNghiep() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

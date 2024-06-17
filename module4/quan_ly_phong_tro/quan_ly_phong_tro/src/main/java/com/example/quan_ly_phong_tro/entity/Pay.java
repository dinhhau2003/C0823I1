package com.example.quan_ly_phong_tro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payId;
    @NotBlank(message = "Không được để trống")
    private String payName;
    @OneToMany(mappedBy = "payName" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<MotelRoom> motelRooms;

    public Pay() {
    }

    public Pay(Integer payId, String payName, Set<MotelRoom> motelRooms) {
        this.payId = payId;
        this.payName = payName;
        this.motelRooms = motelRooms;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public Set<MotelRoom> getMotelRooms() {
        return motelRooms;
    }

    public void setMotelRooms(Set<MotelRoom> motelRooms) {
        this.motelRooms = motelRooms;
    }
}

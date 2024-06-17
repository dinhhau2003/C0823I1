package com.example.benh_an.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loaiBenhNhan;
    @OneToMany(mappedBy = "benhNhan",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<BenhAn> benhAns;

    public BenhNhan() {
    }

    public BenhNhan(Long id, String loaiBenhNhan, Set<BenhAn> benhAns) {
        this.id = id;
        this.loaiBenhNhan = loaiBenhNhan;
        this.benhAns = benhAns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoaiBenhNhan() {
        return loaiBenhNhan;
    }

    public void setLoaiBenhNhan(String loaiBenhNhan) {
        this.loaiBenhNhan = loaiBenhNhan;
    }

    public Set<BenhAn> getBenhAns() {
        return benhAns;
    }

    public void setBenhAns(Set<BenhAn> benhAns) {
        this.benhAns = benhAns;
    }
}

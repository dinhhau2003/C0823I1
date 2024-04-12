package com.example.benh_an.model;

public class BenhNhan {
    private int maBenhNhan;
    private String tenBenhNhan;


    public BenhNhan() {
    }

    public BenhNhan(int maBenhNhan, String tenBenhNhan) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }
}

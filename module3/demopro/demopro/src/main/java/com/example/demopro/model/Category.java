package com.example.demopro.model;

public class Category {
    private int id_category;
    private String ten_danh_muc;

    public Category() {
    }

    public Category(int id_category, String ten_danh_muc) {
        this.id_category = id_category;
        this.ten_danh_muc = ten_danh_muc;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }
}

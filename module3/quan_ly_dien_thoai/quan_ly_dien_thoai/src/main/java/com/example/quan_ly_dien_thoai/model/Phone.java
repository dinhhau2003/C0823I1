package com.example.quan_ly_dien_thoai.model;

public class Phone {
    private int id;
    private String name;
    private double price = 0.0d;
    private int id_danh_muc;
    private String ten_danh_muc;


    public Phone() {
    }

    public Phone(int id, String name, double price, int id_danh_muc, String ten_danh_muc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.id_danh_muc = id_danh_muc;
        this.ten_danh_muc = ten_danh_muc;
    }

    public Phone(int id, String name, double price, String tenDanhMuc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ten_danh_muc = ten_danh_muc;
    }

//    public Phone(int id, String name, double price, String ten_danh_muc) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.ten_danh_muc = ten_danh_muc;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_danh_muc() {
        return id_danh_muc;
    }

    public void setId_danh_muc(int id_danh_muc) {
        this.id_danh_muc = id_danh_muc;
    }

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }
}

package com.example.thi_dto.model;

public class Product {
    private int id_product;
    private String name;
    private float gia;
    private String soLuong;
    private String color;
    private String moTa;
    private int id_category;

    public Product() {
    }

    public Product(int id_product, String name, float gia, String soLuong, String color, String moTa, int id_category) {
        this.id_product = id_product;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.id_category = id_category;
    }

    public Product(String name, float gia, String soLuong, String color, String moTa, int id_category) {
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.id_category = id_category;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}

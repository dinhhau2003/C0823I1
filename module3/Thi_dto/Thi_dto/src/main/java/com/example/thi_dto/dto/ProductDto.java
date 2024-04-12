package com.example.thi_dto.dto;

public class ProductDto {
    private int id_product;
    private String name;
    private float gia;
    private String soLuong;
    private String color;
    private String moTa;
    private String ten_danh_muc;

    public ProductDto() {
    }

    public ProductDto(int id_product, String name, float gia, String soLuong, String color, String moTa, String ten_danh_muc) {
        this.id_product = id_product;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.ten_danh_muc = ten_danh_muc;
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

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }
}

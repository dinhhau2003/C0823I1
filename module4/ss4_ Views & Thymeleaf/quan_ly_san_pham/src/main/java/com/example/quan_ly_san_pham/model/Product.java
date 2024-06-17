package com.example.quan_ly_san_pham.model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private String desc;
    private String nsx;

    public Product() {
    }

    public Product(int id, String nameProduct, double price, String desc, String nsx) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.desc = desc;
        this.nsx = nsx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }
}

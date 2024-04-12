package com.example.on_tap.model;

import java.sql.Date;

public class Product {
    private int idProduct;
    private String nameProduct;
    private boolean gender;
    Date day;
    private int maCategory;
    private String nameCategory;


    public Product() {
    }

    public Product(int idProduct, String nameProduct, boolean gender, Date day, int maCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.gender = gender;
        this.day = day;
        this.maCategory = maCategory;
    }

    public Product(String nameProduct, boolean gender, Date day, int maCategory) {
        this.gender = gender;
        this.nameProduct = nameProduct;

        this.day = day;
        this.maCategory = maCategory;
    }

    public Product(int idProduct, String nameProduct, boolean gender, Date day, String nameCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.day = day;
        this.gender = gender;

        this.nameCategory = nameCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getMaCategory() {
        return maCategory;
    }

    public void setMaCategory(int maCategory) {
        this.maCategory = maCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}

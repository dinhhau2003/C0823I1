package com.example.productti.model;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private Date day;
    private int idCategory;
    private String nameCategory;

    public Product() {
    }

    public Product(int id, String name, Date day, int idCategory, String nameCategory) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }
    public Product(int id, String name, Date day, int idCategory) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.idCategory = idCategory;
    }
    public Product(String name, Date day, int idCategory) {
        this.name = name;
        this.day = day;
        this.idCategory = idCategory;
    }
    public Product(int id, String name, Date day, String nameCategory) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.nameCategory = nameCategory;
    }



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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}

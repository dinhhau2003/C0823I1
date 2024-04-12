package com.example.product.model;

public class Product {
    private int id ;
    private String name;
    private float  price;
    private String description;
    private int id_Manufactor;

    public Product() {
    }

    public Product(int id, String name, float price, String description, int id_Manufactor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.id_Manufactor = id_Manufactor;
    }

    public Product(String name, float price, String description, int id_Manufactor) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.id_Manufactor = id_Manufactor;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_Manufactor() {
        return id_Manufactor;
    }

    public void setId_Manufactor(int id_Manufactor) {
        this.id_Manufactor = id_Manufactor;
    }
}

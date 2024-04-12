package com.example.product.dto;

public class ProductDto {
    private int id;
    private String name;
    private float price;
    private String description;
    private String name_manufactor;

    public ProductDto() {
    }

    public ProductDto(int id, String name, float price, String description, String name_manufactor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.name_manufactor = name_manufactor;
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

    public String getName_manufactor() {
        return name_manufactor;
    }

    public void setName_manufactor(String name_manufactor) {
        this.name_manufactor = name_manufactor;
    }
}

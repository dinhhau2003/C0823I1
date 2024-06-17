package com.example.product_string.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class ProductDetailsResponse {
    private Long id;
    private String name;
    private String categoryName;
    private Double price;
    private Date date;

    public ProductDetailsResponse() {
    }

    public ProductDetailsResponse(Long id, String name, String categoryName, Double price, Date date) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

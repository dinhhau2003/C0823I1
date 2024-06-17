package com.example.product_final.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotBlank(message = "Không được để trống")
    private String productName;
    @NotNull(message = "Không được để trống")
    private LocalDate dateOfManufacture;
    @NotNull(message = "Không được để trống")
    private Double price;
    @NotNull(message = "không được để trống")
    private int gender;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(Long productId, String productName, LocalDate dateOfManufacture, Double price, int gender, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
        this.gender = gender;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

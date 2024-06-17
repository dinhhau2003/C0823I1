package com.example.ontapti.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @NotBlank(message = "Không được để trống")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    @NotBlank(message = "Không được để trống")
    private String productName;
    @NotNull(message = "Không được để trống")
    private LocalDate dateOfManufacture;
    @NotNull(message = "Không được để trống")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @NotNull(message = "Không được để trống")
    private Category category;

    public Product() {
    }

    public Product(String productId, String productName, LocalDate dateOfManufacture, Double price, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

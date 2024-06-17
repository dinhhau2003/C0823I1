package com.example.product_string.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Pattern(regexp = "SP-\\d{3}", message = "{create.id}")
    private Long id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max=50, message = "Vui lòng nhập nhỏ hơn 50 và lơn hơn 5")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @NotNull(message = "Không được để trống")
    private Category category;
    @NotNull(message = "Vui lòng nhập giá tiền")
    @DecimalMin(value = "0",message = "không được âm")
    private Double price;

    private Date date;

    public Product() {
    }

    public Product(Long id, String name, Category category, Double price, Date date) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

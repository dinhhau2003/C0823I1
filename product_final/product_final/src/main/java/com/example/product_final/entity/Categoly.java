package com.example.product_final.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class Categoly {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categolyId;
    @NotNull(message = "không được để trống")
    private String categolyName;
    @OneToMany(mappedBy = "categoly", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> product;

    public Categoly() {
    }

    public Categoly(Long categolyId, String categolyName, Set<Product> product) {
        this.categolyId = categolyId;
        this.categolyName = categolyName;
        this.product = product;
    }

    public Long getCategolyId() {
        return categolyId;
    }

    public void setCategolyId(Long categolyId) {
        this.categolyId = categolyId;
    }

    public String getCategolyName() {
        return categolyName;
    }

    public void setCategolyName(String categolyName) {
        this.categolyName = categolyName;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}

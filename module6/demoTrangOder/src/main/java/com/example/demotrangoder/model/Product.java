package com.example.demotrangoder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String createAt;
    private String productCode;
    private String productImgUrl;
    private String productName;
    private Double productPrice;
    private String productStatus;
    private String updateDay;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OderDetail> oderDetails;
    // getters and setters
    public Product(Long productId) {
        this.productId = productId;
    }

}
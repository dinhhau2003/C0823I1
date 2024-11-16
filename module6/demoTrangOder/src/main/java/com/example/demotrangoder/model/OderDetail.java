package com.example.demotrangoder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderDetailId;
    private int quantity;
    private String shippingDay;
    private Boolean status;
    private Double totalMoneyOder;

    @ManyToOne
    @JoinColumn(name = "call_oder_request_id")
    private CallOderRequest callOderRequest;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // getters and setters
}
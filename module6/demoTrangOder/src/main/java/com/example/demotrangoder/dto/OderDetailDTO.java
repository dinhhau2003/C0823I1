package com.example.demotrangoder.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OderDetailDTO {
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private String shippingDay;
}

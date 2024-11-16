package com.example.projectc1023i1.Dto.product.income;

import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productCode;
    @Size(min = 3, message = "Product name must be at least 3 characters")
    private String productName;
    private double productPrice;
    private String productImgUrl;
    private Integer categoryId;
}

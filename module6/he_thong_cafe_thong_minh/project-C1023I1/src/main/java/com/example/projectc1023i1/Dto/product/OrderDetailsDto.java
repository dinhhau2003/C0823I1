package com.example.projectc1023i1.Dto.product;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class OrderDetailsDto {
    private Integer tableId;
    private int quantity;
    private LocalDateTime shippingDay;
    private double totalMoneyOrder;
    private String status;
    private LocalDateTime callOrderTime;
    private LocalDateTime callServiceTime;
    private int userId;
    private Integer productId;  // Thêm productId

    // Getters và Setters cho tất cả các thuộc tính

}

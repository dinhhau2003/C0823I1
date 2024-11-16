package com.example.projectc1023i1.Dto.product;

import com.example.projectc1023i1.model.product.OrderDetails;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class CallOrderRequestDto {
    private int tableId;
    private String userName;
    private List<OrderDetails> orderDetails;


}


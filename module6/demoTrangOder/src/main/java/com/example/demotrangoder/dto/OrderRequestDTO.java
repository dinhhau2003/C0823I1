package com.example.demotrangoder.dto;

import com.example.demotrangoder.model.Table;
import com.example.demotrangoder.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private User user;
    private Table table;
    private List<ProductDTO> products;
}

package com.example.thi_dto.service;

import com.example.thi_dto.dto.ProductDto;
import com.example.thi_dto.model.Product;

import java.util.List;

public interface IProductService {
    public List<ProductDto> findAllDto();
    void addProduct(Product product);
    boolean deleteProduct(int id);
}

package com.example.thi_dto.repository;

import com.example.thi_dto.dto.ProductDto;
import com.example.thi_dto.model.Product;

import java.util.List;

public interface IProductRepository {
    public List<ProductDto> findAllDto();
    void addProduct(Product product);
    boolean deleteProduct(int id);
}

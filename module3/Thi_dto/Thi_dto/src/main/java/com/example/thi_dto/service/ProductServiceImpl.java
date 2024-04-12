package com.example.thi_dto.service;

import com.example.thi_dto.dto.ProductDto;
import com.example.thi_dto.model.Product;
import com.example.thi_dto.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    ProductRepositoryImpl productRepository=new ProductRepositoryImpl();
    @Override
    public List<ProductDto> findAllDto() {
        return productRepository.findAllDto();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }
}

package com.example.ontapti.service;

import com.example.ontapti.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable);
    Page<Product> searchProductName(String productName, Pageable pageable);
    void createNewProduct(Product product);
}

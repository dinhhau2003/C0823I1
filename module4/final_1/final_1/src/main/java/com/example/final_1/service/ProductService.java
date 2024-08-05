package com.example.final_1.service;

import com.example.final_1.entity.Category;
import com.example.final_1.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);
    Page<Product> searchProducts(String productName, Category category, Pageable pageable);
    void createNewProduct(Product product);
    Product findByIdProduct(Long productId);
    void deleleProduct(Long productId);
}

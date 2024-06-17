package com.example.product_string.service;

import com.example.product_string.entity.Category;
import com.example.product_string.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);
    Page<Product> searchProductName(String productName, Pageable pageable);
    void createNewProduct(Product product);
    Product findByIdProduct(Long productId);
    void deleleProduct(Long productId);

    Page<Product> searchProducts(String productName, Category category, Pageable pageable);

}

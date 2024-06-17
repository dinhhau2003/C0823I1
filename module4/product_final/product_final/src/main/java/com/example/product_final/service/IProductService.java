package com.example.product_final.service;

import com.example.product_final.entity.Category;
import com.example.product_final.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable);
    void createNewProduct(Product product);
    Product findByIdProduct(Long productId);
    void deleleProduct(Long productId);
    Page<Product> searchProduct(String productName, Category category, Pageable pageable);

}

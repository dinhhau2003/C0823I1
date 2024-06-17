package com.example.product_final.repository;

import com.example.product_final.entity.Category;
import com.example.product_final.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);
    Page<Product> findAllByProductNameContainingAndCategory(String productName, Category category,Pageable pageable);
}

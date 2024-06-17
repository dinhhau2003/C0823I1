package com.example.product_string.repository;

import com.example.product_string.entity.Category;
import com.example.product_string.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByNameContaining(String productName, Pageable pageable);
    Page<Product> findAllByNameContainingAndCategory(String name, Category category, Pageable pageable);

}

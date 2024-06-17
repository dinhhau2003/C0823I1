package com.example.ontapti.repository;

import com.example.ontapti.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);
}

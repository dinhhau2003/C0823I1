package com.example.product_final.repository;

import com.example.product_final.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}

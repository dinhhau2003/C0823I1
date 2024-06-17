package com.example.blog_string.repository;

import com.example.blog_string.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,String> {
}

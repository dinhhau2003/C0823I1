package com.example.ontapti.repository;

import com.example.ontapti.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, String> {
}

package com.example.productti.repository;

import com.example.productti.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCategory();
}

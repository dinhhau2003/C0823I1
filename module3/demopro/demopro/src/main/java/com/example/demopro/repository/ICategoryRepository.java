package com.example.demopro.repository;

import com.example.demopro.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCategory();
}

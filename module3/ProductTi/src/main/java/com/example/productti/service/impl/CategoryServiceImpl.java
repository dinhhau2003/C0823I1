package com.example.productti.service.impl;

import com.example.productti.model.Category;
import com.example.productti.repository.impl.CategoryRepositoryImpl;
import com.example.productti.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}

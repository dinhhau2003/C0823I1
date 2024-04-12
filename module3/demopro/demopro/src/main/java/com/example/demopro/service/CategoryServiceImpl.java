package com.example.demopro.service;

import com.example.demopro.model.Category;
import com.example.demopro.repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}

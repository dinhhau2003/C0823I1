package com.example.thi.service;

import com.example.thi.model.Category;
import com.example.thi.repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}

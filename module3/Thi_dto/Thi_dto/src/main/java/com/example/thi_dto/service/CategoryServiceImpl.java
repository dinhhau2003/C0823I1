package com.example.thi_dto.service;

import com.example.thi_dto.model.Category;
import com.example.thi_dto.repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}

package com.example.on_tap.service;

import com.example.on_tap.model.Category;
import com.example.on_tap.repository.CategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    CategoryRepository categoryRepository=new CategoryRepository();
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}

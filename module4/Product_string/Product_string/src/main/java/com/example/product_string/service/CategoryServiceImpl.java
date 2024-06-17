package com.example.product_string.service;

import com.example.product_string.entity.Category;
import com.example.product_string.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}

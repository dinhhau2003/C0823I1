package com.example.final_1.service;

import com.example.final_1.entity.Category;
import com.example.final_1.repository.CategoryRepository;
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

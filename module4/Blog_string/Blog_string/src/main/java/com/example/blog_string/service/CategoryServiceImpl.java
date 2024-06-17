package com.example.blog_string.service;

import com.example.blog_string.entity.Category;
import com.example.blog_string.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}

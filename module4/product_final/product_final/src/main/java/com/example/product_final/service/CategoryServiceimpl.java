package com.example.product_final.service;

import com.example.product_final.entity.Category;
import com.example.product_final.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceimpl implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}

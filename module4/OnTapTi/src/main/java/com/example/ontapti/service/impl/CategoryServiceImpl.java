package com.example.ontapti.service.impl;

import com.example.ontapti.entity.Category;
import com.example.ontapti.repository.ICategoryRepository;
import com.example.ontapti.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}

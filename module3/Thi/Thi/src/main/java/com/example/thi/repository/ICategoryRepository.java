package com.example.thi.repository;

import com.example.thi.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCategory();
}

package com.example.on_tap.repository;

import com.example.on_tap.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCategory();
}

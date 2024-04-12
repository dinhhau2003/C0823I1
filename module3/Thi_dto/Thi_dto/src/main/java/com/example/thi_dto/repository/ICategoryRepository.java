package com.example.thi_dto.repository;

import com.example.thi_dto.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCategory();
}

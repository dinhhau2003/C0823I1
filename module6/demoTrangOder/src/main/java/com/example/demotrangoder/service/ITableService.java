package com.example.demotrangoder.service;

import com.example.demotrangoder.model.Table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITableService {
    Page<Table> findAll(Pageable pageable);
    Optional<Table> findById(Long id); // Thêm phương thức này

}

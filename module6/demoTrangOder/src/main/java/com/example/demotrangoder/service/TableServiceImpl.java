package com.example.demotrangoder.service;

import com.example.demotrangoder.model.Table;
import com.example.demotrangoder.repo.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableServiceImpl implements ITableService{
    @Autowired
    private TableRepository tableRepository;
    @Override
    public Page<Table> findAll(Pageable pageable) {
        return tableRepository.findAll(pageable);
    }
    @Override
    public Optional<Table> findById(Long id) { // Thêm phương thức này
        return tableRepository.findById(id);
    }
}

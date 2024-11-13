package com.example.api.service.impl;

import com.example.api.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    public Employee saveEmployee(Employee employee);
    Optional<Employee> findById(Long id);

}

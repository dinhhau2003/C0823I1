package com.example.springjpa_hibernate.repository;

import com.example.springjpa_hibernate.model.Customer;

import java.util.List;

public interface IGenerateRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
    List<Customer> findByName(String name);
}

package com.example.springjpa_hibernate.service;

import com.example.springjpa_hibernate.model.Customer;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
    List<Customer> findByName(String name);
}

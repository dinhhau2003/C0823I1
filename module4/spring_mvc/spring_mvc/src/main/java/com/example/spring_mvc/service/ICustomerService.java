package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(Long id);
    void update(Customer customer);
    void remove(Long id);
//    List<Customer> searchByName(String name);
    Page<Customer> searchByName(String firstName, Pageable pageable);
}

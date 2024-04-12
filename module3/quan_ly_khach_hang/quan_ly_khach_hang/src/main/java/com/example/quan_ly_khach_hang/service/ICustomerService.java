package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    boolean add(Customer customer);
    Customer findById(int id);
    void remove(int id);
}

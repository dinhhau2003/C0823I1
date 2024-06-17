package com.example.aspect_log.service;

import com.example.aspect_log.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;

    Customer findOne(Long id) throws Exception;
}

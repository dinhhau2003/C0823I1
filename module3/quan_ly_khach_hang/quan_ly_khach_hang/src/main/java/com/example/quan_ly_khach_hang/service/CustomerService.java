package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.repository.CusomerRepository;
import com.example.quan_ly_khach_hang.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepository customerRepository=new CusomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}

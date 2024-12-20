package com.example.springjpa_hibernate.service;

import com.example.springjpa_hibernate.model.Customer;
import com.example.springjpa_hibernate.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id);
    }
    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }
    @Override
    public void remove(Long id) {
        iCustomerRepository.remove(id);
    }
    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.findByName(name);
    }
}

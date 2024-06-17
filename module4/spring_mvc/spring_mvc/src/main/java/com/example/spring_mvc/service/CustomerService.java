package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Customer;
import com.example.spring_mvc.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> searchByName(String firstName, Pageable pageable) {
        return customerRepository.findCustomerByFirstNameContaining(firstName,pageable);
    }

//    @Override
//    public List<Customer> searchByName(String name) {
//        return customerRepository.findByFirstNameContainingIgnoreCase(name);
//    }

}

package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    Page<Customer> findCustomerByFirstNameContaining(String firstName, Pageable pageable);
}

package com.example.quan_ly_khach_hang.repository;

import com.example.quan_ly_khach_hang.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CusomerRepository implements ICustomerRepository{
    private static List<Customer> customerList=new ArrayList<>();
    static {
        customerList.add( new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerList.add( new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerList.add( new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerList.add( new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerList.add( new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerList.add( new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public boolean add(Customer customer) {
        return customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void remove(int id) {
         customerList.remove(id);
    }
}

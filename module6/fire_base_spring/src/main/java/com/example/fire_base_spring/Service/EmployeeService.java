package com.example.fire_base_spring.Service;

import com.example.fire_base_spring.Entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee updateEmployee(Long id, Employee employeeDetails);
}

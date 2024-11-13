package com.example.api.controller;

import com.example.api.entity.Employee;
import com.example.api.service.impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Cho phép truy cập từ localhost:3000
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> listEmployee(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);  // Nếu không có tham số `page`, mặc định là 1
        int pageSize = size.orElse(3);     // Nếu không có tham số `size`, mặc định là 3

        // Gọi phương thức phân trang từ service
        Page<Employee> employees = employeeService.findAll(PageRequest.of(currentPage - 1, pageSize));

        // Trả về ResponseEntity chứa dữ liệu trang và mã trạng thái HTTP 200 (OK)
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);

        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        Employee updatedEmployee = employeeService.saveEmployee(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.fire_base_spring.Controller;

import com.example.fire_base_spring.Entity.Employee;
import com.example.fire_base_spring.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    // Lấy tất cả nhân viên

    // Hiển thị danh sách tất cả nhân viên
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Thêm mới nhân viên
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // Cập nhật thông tin nhân viên
    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        Optional<Employee> optionalEmployee = employeeService.findById(id);

        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setImgUrl(employee.getImgUrl());

        Employee updatedEmployee = employeeService.saveEmployee(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Lấy thông tin nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa nhân viên
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

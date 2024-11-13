package com.example.c1023l1be.Service.impl;

import com.example.c1023l1be.Dto.UserDTO;
import com.example.c1023l1be.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    User findById(Integer id);
    User save(UserDTO userDTO, Integer id); // Phương thức duy nhất để thêm mới và cập nhật
    void delete(Integer id);
    Page<User> searchUsers(String useName, String fullName, String numberPhone, Pageable pageable); // Tìm kiếm với phân trang
}

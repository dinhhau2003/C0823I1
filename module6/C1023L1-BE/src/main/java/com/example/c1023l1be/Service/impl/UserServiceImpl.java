package com.example.c1023l1be.Service.impl;

import com.example.c1023l1be.Dto.UserDTO;
import com.example.c1023l1be.Entity.Role;
import com.example.c1023l1be.Entity.User;
import com.example.c1023l1be.Repository.RoleRepository;
import com.example.c1023l1be.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(UserDTO userDTO, Integer id) {
        User user;
        if (id == null) {
            user = new User(); // Thêm mới
            user.setCreatAt(new Date());
        } else {
            user = userRepository.findById(id).orElse(null); // Cập nhật
            if (user != null) {
                user.setUpdateAt(new Date());
            }
        }

        if (user != null) {
            BeanUtils.copyProperties(userDTO, user, "userId", "creatAt");
            Role role = roleRepository.findById(userDTO.getRoleId()).orElse(null);
            user.setRole(role);
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> searchUsers(String userName, String fullName, String numberPhone, Pageable pageable) {
        return userRepository.findByUserNameContainingIgnoreCaseAndFullNameContainingIgnoreCaseAndNumberPhoneContaining(userName, fullName, numberPhone, pageable);
    }
}

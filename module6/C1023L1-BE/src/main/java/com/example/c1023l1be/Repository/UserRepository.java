package com.example.c1023l1be.Repository;

import com.example.c1023l1be.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE " +
            "(:userName IS NULL OR LOWER(u.userName) LIKE LOWER(CONCAT('%', :userName, '%'))) AND " +
            "(:fullName IS NULL OR LOWER(u.fullName) LIKE LOWER(CONCAT('%', :fullName, '%'))) AND " +
            "(:numberPhone IS NULL OR u.numberPhone LIKE CONCAT('%', :numberPhone, '%'))")
    Page<User> searchUsers(
            @Param("userName") String userName,
            @Param("fullName") String fullName,
            @Param("numberPhone") String numberPhone,
            Pageable pageable);
}

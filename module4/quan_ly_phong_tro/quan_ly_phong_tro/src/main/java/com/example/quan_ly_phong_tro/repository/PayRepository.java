package com.example.quan_ly_phong_tro.repository;

import com.example.quan_ly_phong_tro.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository<Pay,Integer> {
}

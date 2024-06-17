package com.example.duan.repository;

import com.example.duan.entity.DoanhNghiep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoanhNghiepRepository extends JpaRepository<DoanhNghiep,Integer> {
}

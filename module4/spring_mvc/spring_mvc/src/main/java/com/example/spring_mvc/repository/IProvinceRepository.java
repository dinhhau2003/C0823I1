package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province,Long> {
}

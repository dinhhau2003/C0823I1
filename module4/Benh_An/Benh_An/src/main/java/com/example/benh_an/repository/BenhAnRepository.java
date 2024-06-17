package com.example.benh_an.repository;

import com.example.benh_an.entity.BenhAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenhAnRepository extends JpaRepository<BenhAn,String> {
}

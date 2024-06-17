package com.example.benh_an.repository;

import com.example.benh_an.entity.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenhNhanRepository extends JpaRepository<BenhNhan,Long> {
}

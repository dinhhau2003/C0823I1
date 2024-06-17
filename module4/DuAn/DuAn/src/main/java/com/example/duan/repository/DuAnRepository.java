package com.example.duan.repository;

import com.example.duan.entity.DoanhNghiep;
import com.example.duan.entity.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuAnRepository extends JpaRepository<DuAn,String> {
    Page<DuAn> findAllByTenDuAnContaining(String tenDuAn, Pageable pageable);

    Page<DuAn> findAllByTenDuAnContainingAndDoanhNghiep(String tenDuAn, DoanhNghiep doanhNghiep, Pageable pageable);

}

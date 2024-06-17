package com.example.thi.repository;

import com.example.thi.entity.ThongTin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<ThongTin,Long> {
    Page<ThongTin> findAllByMucGiamGiaContaining(Double mucGiamGia, Pageable pageable);
    @Query(value = "SELECT * FROM thong_tin where muc_giam_gia", nativeQuery = true)
    List<ThongTin> searchByName1(@Param("searchName") Double mucGiamGia);

}

package com.example.duan.service;

import com.example.duan.entity.DoanhNghiep;
import com.example.duan.entity.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DuAnService {
    Page<DuAn> findAllDuAn(Pageable pageable);
    void createNewDuan(DuAn duAn);
    DuAn findByIdDuAn(String maDuAn);
    void deleleDuAn(String maDuAn);
    Page<DuAn> searchDuAnName(String tenDuAn, DoanhNghiep doanhNghiep, Pageable pageable);


}

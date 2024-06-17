package com.example.duan.service;

import com.example.duan.entity.DoanhNghiep;
import com.example.duan.entity.DuAn;
import com.example.duan.repository.DuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DuAnServiceImpl implements DuAnService{
    @Autowired
     private DuAnRepository duAnRepository;
    @Override
    public Page<DuAn> findAllDuAn(Pageable pageable) {
        return duAnRepository.findAll(pageable);
    }

    @Override
    public void createNewDuan(DuAn duAn) {
        duAnRepository.save(duAn);
    }

    @Override
    public DuAn findByIdDuAn(String maDuAn) {
        return duAnRepository.findById(maDuAn).orElse(null);
    }

    @Override
    public void deleleDuAn(String maDuAn) {
        duAnRepository.deleteById(maDuAn);
    }

    @Override
    public Page<DuAn> searchDuAnName(String tenDuAn, DoanhNghiep doanhNghiep, Pageable pageable) {
        if (doanhNghiep == null) {
            return duAnRepository.findAllByTenDuAnContaining(tenDuAn, pageable);
        } else {
            return duAnRepository.findAllByTenDuAnContainingAndDoanhNghiep(tenDuAn, doanhNghiep, pageable);
        }
    }
}

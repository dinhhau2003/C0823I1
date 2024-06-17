package com.example.thi.service;

import com.example.thi.entity.ThongTin;
import com.example.thi.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiService implements IKhuyenMaiService{
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public Page<ThongTin> findAllKM(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable);
    }

    @Override
    public void createNewKM(ThongTin thongTin) {
        khuyenMaiRepository.save(thongTin);
    }

    @Override
    public ThongTin findByIdKM(Long id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public void deleleKM(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public Page<ThongTin> searchKM(Double mucGiamGia, Pageable pageable) {
        return khuyenMaiRepository.findAllByMucGiamGiaContaining(mucGiamGia,pageable);
    }


}

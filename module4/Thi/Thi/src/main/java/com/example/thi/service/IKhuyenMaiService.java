package com.example.thi.service;

import com.example.thi.entity.ThongTin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IKhuyenMaiService {
    Page<ThongTin> findAllKM(Pageable pageable);
    void createNewKM(ThongTin thongTin);
    ThongTin findByIdKM(Long id);
    void deleleKM(Long id);
    Page<ThongTin> searchKM(Double mucGiamGia, Pageable pageable);


}

package com.example.benh_an.service;

import com.example.benh_an.entity.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBenhAnService {
    Page<BenhAn> findAllBenhAn(Pageable pageable);
    void createNewBenhAn(BenhAn benhAn);

}

package org.arthur.exam_module_4.service;

import org.arthur.exam_module_4.dto.DuAnDTO;
import org.arthur.exam_module_4.model.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDuAnService {
    Page<DuAn> getList(String valueSearch, Pageable pageable);
    DuAn findById(Long id);
    boolean add(DuAn duAn);
    boolean edit(DuAn duAn);
    boolean delete(DuAn duAn);
    void calChiPhi(DuAnDTO duAnDTO);
    void  addNgayDangKy(DuAnDTO duAnDTO);
    boolean checkExistMaDuAn(DuAnDTO duAnDTO);
}

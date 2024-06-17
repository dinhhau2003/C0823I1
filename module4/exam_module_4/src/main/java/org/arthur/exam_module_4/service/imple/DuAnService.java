package org.arthur.exam_module_4.service.imple;

import org.arthur.exam_module_4.dto.DuAnDTO;
import org.arthur.exam_module_4.model.DuAn;
import org.arthur.exam_module_4.repository.IDuAnRepository;
import org.arthur.exam_module_4.service.IDuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Service
public class DuAnService implements IDuAnService {
    @Autowired
    IDuAnRepository duAnRepository;
    @Override
    public Page<DuAn> getList(String valueSearch, Pageable pageable) {
        return duAnRepository.getList(valueSearch,pageable);
    }

    @Override
    public DuAn findById(Long id) {
        return duAnRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(DuAn duAn) {
        try{
            duAnRepository.save(duAn);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean edit(DuAn duAn) {
        try{
            duAnRepository.save(duAn);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(DuAn duAn) {
        duAn.setActive(false);
        try{
            duAnRepository.save(duAn);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public void calChiPhi(DuAnDTO duAnDTO) {
        double kinhPhi = duAnDTO.getKinhPhi();
        double thoiGian = duAnDTO.getThoiGianDangKy();
        if(kinhPhi<1000000000){
            duAnDTO.setChiPhi(kinhPhi*1/100*thoiGian);
        } else if (kinhPhi<=500000000){
            duAnDTO.setChiPhi(kinhPhi*2/100*thoiGian);
        } else duAnDTO.setChiPhi(kinhPhi*3/100*thoiGian);
    }

    @Override
    public void addNgayDangKy(DuAnDTO duAnDTO) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        try {
            duAnDTO.setNgayDangKy(formatter.parse(String.valueOf(date)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkExistMaDuAn(DuAnDTO duAnDTO) {
        return duAnRepository.existsByMaDuAn(duAnDTO.getMaDuAn());
    }
}

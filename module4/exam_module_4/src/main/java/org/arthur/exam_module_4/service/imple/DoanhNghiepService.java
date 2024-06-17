package org.arthur.exam_module_4.service.imple;

import org.arthur.exam_module_4.model.DoanhNghiep;
import org.arthur.exam_module_4.repository.IDoanhNghiepRepository;
import org.arthur.exam_module_4.service.IDoanhNghiepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoanhNghiepService implements IDoanhNghiepService {
    @Autowired
    IDoanhNghiepRepository studentClassRepository;
    @Override
    public List<DoanhNghiep> getList() {
        return studentClassRepository.findAll();
    }
}

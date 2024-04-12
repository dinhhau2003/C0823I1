package com.example.hanghoa.service;

import com.example.hanghoa.model.HangHoa;
import com.example.hanghoa.repository.HangRepositoryImpl;

import java.util.List;

public class HangService implements IHangService{
    HangRepositoryImpl hangRepository=new HangRepositoryImpl();
    @Override
    public List<HangHoa> findAllHang() {
        return hangRepository.findAllHang();
    }

    @Override
    public void addHang(HangHoa hangHoa) {
        hangRepository.addHang(hangHoa);
    }

    @Override
    public HangHoa findById(int id) {
        return hangRepository.findById(id);
    }

    @Override
    public void update(HangHoa hangHoa) {
        hangRepository.update(hangHoa);
    }

    @Override
    public boolean delete(int id) {
        return hangRepository.delete(id);
    }

    @Override
    public List<HangHoa> search(String tenLoaiHang, String name) {
        return hangRepository.search(tenLoaiHang,name);
    }
}

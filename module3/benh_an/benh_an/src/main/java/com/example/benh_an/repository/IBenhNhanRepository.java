package com.example.benh_an.repository;

import com.example.benh_an.model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepository {
    List<BenhNhan> findAllBenhNhan();
}

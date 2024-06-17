package com.example.quan_ly_phong_tro.service;

import com.example.quan_ly_phong_tro.entity.MotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MotelRoomService {
    Page<MotelRoom> findAlMotelRoom(Pageable pageable);

}

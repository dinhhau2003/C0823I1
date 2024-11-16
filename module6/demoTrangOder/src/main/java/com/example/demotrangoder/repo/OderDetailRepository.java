package com.example.demotrangoder.repo;

import com.example.demotrangoder.model.CallOderRequest;
import com.example.demotrangoder.model.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OderDetailRepository extends JpaRepository<OderDetail,Long> {
    // Tìm OderDetails theo CallOderRequest
    List<OderDetail> findByCallOderRequest(CallOderRequest callOderRequest);
}

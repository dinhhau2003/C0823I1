package com.example.demotrangoder.repo;

import com.example.demotrangoder.model.CallOderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallOderRequestRepository extends JpaRepository<CallOderRequest,Long> {
    List<CallOderRequest> findByTableTableId(Long tableId);

}

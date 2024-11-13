package com.example.websocket.Repo;

import com.example.websocket.Entity.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableInfoRepository extends JpaRepository<TableInfo, Long> {
}

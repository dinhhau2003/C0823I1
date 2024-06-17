package com.example.benhan_final.repository;

import com.example.benhan_final.entity.RecordClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordClassRepository extends JpaRepository<RecordClass,Integer> {
}

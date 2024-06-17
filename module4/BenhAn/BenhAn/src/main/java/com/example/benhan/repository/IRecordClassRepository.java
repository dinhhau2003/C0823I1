package com.example.benhan.repository;

import com.example.benhan.entity.RecordClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordClassRepository extends JpaRepository<RecordClass,Integer> {
}

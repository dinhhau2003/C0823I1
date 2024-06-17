package org.arthur.exam_module_4.repository;

import org.arthur.exam_module_4.model.DoanhNghiep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoanhNghiepRepository extends JpaRepository<DoanhNghiep,Long> {
}

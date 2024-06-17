package org.arthur.exam_module_4.repository;

import org.arthur.exam_module_4.model.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuAnRepository extends JpaRepository<DuAn,Long> {
    @Query(nativeQuery = true, value = "select d.* " +
            "from du_an d join doanh_nghiep dn on d.doanh_nghiep_id = dn.id " +
            "where d.active = true and ( dn.name like %?1 or d.ma_du_an like %?1 or d.ten_du_an like %?1 or d.kinh_phi like %?1 or d.ngay_dang_ky like %?1 or d.thoi_gian_dang_ky like %?1)",
    countQuery = "select * from du_an d")
    Page<DuAn> getList(String valueSearch, Pageable pageable);
    boolean existsByMaDuAn(String maDuAn);
}

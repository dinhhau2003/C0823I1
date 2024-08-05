package TaiKhoan.repository;

import TaiKhoan.model.TaiKhoanNganHang;

import java.util.List;

public interface IBankRepository {
    void addBank(TaiKhoanNganHang taiKhoanNganHang);
    List<TaiKhoanNganHang> getList();
    void update(List<TaiKhoanNganHang> taiKhoanNganHangList);
}

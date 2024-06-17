package org.arthur.exam_module_4.dto;
import jakarta.validation.constraints.*;
import org.arthur.exam_module_4.model.DoanhNghiep;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class DuAnDTO implements Validator {
    private Long id;
    @NotBlank(message = "Nhập tên mã dự án")
    @Pattern(regexp = "[D][A][-]*(\\d{4})",message = "Sai định dạng, Định dạng đúng là DA-XXXX")
    private String maDuAn;

    @NotNull(message = "vui lòng chọn doanh nghiệp")
    private DoanhNghiep doanhNghiep;
    @NotBlank(message = "Tên Dự Án không được để trống")
    private String tenDuAn;
    @NotNull(message = "Kinh phí không được để trống")
    @Min(value = 30000000, message = "Kinh phí lơn hơn hoặc bằng 30000000 VND")
    private double kinhPhi;
    @NotBlank(message = "Mô tả không được để tróng")
    private String moTa;
    private Date ngayDangKy;
    @NotNull(message = "Nhập thời gian đăng ký")
    @Min(value = 1, message = "Thời gian đăng ký giới thiệu là 1-12 tháng ")
    @Max(value = 12, message = "Thời gian đăng ký giới thiệu là 1-12 tháng ")
    private double thoiGianDangKy;
    private double chiPhi;


    public DuAnDTO() {
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoanhNghiep getHocSinh() {
        return doanhNghiep;
    }

    public void setHocSinh(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public double getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(double thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

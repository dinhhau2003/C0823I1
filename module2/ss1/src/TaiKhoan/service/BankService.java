package TaiKhoan.service;

import TaiKhoan.model.TaiKhoanNganHang;
import TaiKhoan.model.TaiKhoanThanhToan;
import TaiKhoan.model.TaiKhoanTietKiem;
import TaiKhoan.repository.BankRepository;
import TaiKhoan.repository.IBankRepository;
import TaiKhoan.until.CheckInputData;
import TaiKhoan.until.Validation;

import java.util.ArrayList;
import java.util.List;

public class BankService implements IBankService {
    private static IBankRepository bankRepository = new BankRepository();
    public void addBank() {
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng thêm loại tiết kiệm tài khoản:");
            System.out.println("1.Thêm mới tài khoản tiết kiệm");
            System.out.println("2.Thêm mới tài khoản thanh toán");
            System.out.println("3.Back to menu.");
            int choice = CheckInputData.CheckInputOption("Mời bạn nhập chức năng thêm:", 1, 3);
            switch (choice) {
                case 1: {
                    addTaiKhoanTietKiem();
                    break;
                }
                case 2: {
                    addTaiKhoanThanhToan();
                    break;
                }
                default: {
                    flag = false;

                }
            }
        } while (flag);

    }

    @Override
    public void displayBank() {
        List<TaiKhoanNganHang> taiKhoanNganHangList = bankRepository.getList();
        for (TaiKhoanNganHang taiKhoanNganHang : taiKhoanNganHangList) {
            System.out.println(taiKhoanNganHang.getInfoToCSV());
        }

    }

    @Override
    public void removeBank(int idBankDel) {
        List<TaiKhoanNganHang> taiKhoanNganHangList = bankRepository.getList();
        List<String> stringList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < taiKhoanNganHangList.size(); i++) {
            if (taiKhoanNganHangList.get(i).getId() == idBankDel) {
                flag = true;
                System.out.println("Đã tìm thấy mã tài khoản tương ứng.");
                String mess = "Bạn có muốn chắc chắn xóa không?(Y/N)";
                if (Validation.confirm(mess)) {
                    taiKhoanNganHangList.remove(i);
                    bankRepository.update(taiKhoanNganHangList);
                    System.out.println("Đã xóa thành công!!!");
                    return;
                }
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy tài khoản ngân hàng.");
        }
    }

    @Override
    public void findBank(String nameFind) {
        boolean flag = false;
        List<TaiKhoanNganHang> taiKhoanNganHangList = bankRepository.getList();
        for (TaiKhoanNganHang taiKhoanNganHang : taiKhoanNganHangList) {
            if (taiKhoanNganHang.getTenchuTaiKhoan().equals(nameFind)) {
                flag = true;
                System.out.println("Đã tìm thấy tên tài khoản ngân hàng.");
                System.out.println(taiKhoanNganHang);
                break;
            }

        }
        if (!flag) {
            System.out.println("Không tìm thấy tên tài khoản ngân hàng.");
        }
    }
    public void addTaiKhoanThanhToan() {
        while (true) {
            // int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan, String soThe, double soTienTrongTaiKhoan
            int id = CheckInputData.checkInputInt("Mời bạn nhập id ngân hàng:", 0, "Id");
            String maTaiKhoan = CheckInputData.checkInputmaTkThanhToan("Mời bạn nhập mã tài khoản:");
            String tenchuTaiKhoan = CheckInputData.checkInputNull("Mời bạn nhập tên chủ tài khoản:", "Tên chủ tài khoản");
            String ngaytaoTaiKhoan = CheckInputData.checkInputDate("Mời bạn nhập ngày tạo tài khoản:");
            String soThe = CheckInputData.checkInputNull("Mời bạn nhập số thẻ:", "Số thẻ");
            double soTienTrongTaiKhoan = CheckInputData.checkInputDouble("Mời bạn nhập số tiền trong tài khoản:", 0, "Số tiền trong tài khoản");
            TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(id, maTaiKhoan, tenchuTaiKhoan, ngaytaoTaiKhoan, soThe, soTienTrongTaiKhoan);
            bankRepository.addBank(taiKhoanThanhToan);
            System.out.println("Đã thêm thành công.");

            String mess = "Bạn có muốn thêm nữa không?(Y/N)";
            if (Validation.confirm(mess)) {
                continue;
            } else {
                return;
            }
        }

    }

    public  void addTaiKhoanTietKiem() {
        while (true) {
            //int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan, double tienGoi, String ngayGoi, String laiSuat, int kiHan
            int id = CheckInputData.checkInputInt("Mời bạn nhập id ngân hàng:", 0, "Id");
            String maTaiKhoan = CheckInputData.checkInputmaTkTietKiem("Mời bạn nhập mã tài khoản:");
            String tenchuTaiKhoan = CheckInputData.checkInputNull("Mời bạn nhập tên chủ tài khoản:", "Tên chủ tài khoản");
            String ngaytaoTaiKhoan = CheckInputData.checkInputDate("Mời bạn nhập ngày tạo tài khoản:");
            double tienGoi = CheckInputData.checkInputDouble("Mời bạn nhập số tiền gởi:", 0, "Số tiền gởi");
            String ngayGoi = CheckInputData.checkInputDate("Mời bạn nhập ngày gởi ngân hàng: ");
            String laiXuat = CheckInputData.checkInputNull("Mời bạn nhập lãi xuất ngân hàng:","Lãi suất ngân hàng");
            int kiHan  = CheckInputData.checkInputInt("Mời bạn nhập kí Han:", 0, "Ki Han");
            TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(id, maTaiKhoan, tenchuTaiKhoan, ngaytaoTaiKhoan, tienGoi, ngayGoi, laiXuat, kiHan);
            bankRepository.addBank(taiKhoanTietKiem);
            System.out.println("Đã thêm thành công.");
            String mess = "Bạn có muốn thêm nữa không?(Y/N)";
            if (Validation.confirm(mess)) {
                continue;
            } else {
                return;
            }
        }
    }
}

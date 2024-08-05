package TaiKhoan.repository;

import TaiKhoan.model.TaiKhoanNganHang;
import TaiKhoan.model.TaiKhoanThanhToan;
import TaiKhoan.model.TaiKhoanTietKiem;
import TaiKhoan.until.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class BankRepository implements IBankRepository{
    private static ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private final String BANK_DATA = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\TaiKhoan\\data\\taikhoannganhang.csv";
    @Override
    public void addBank(TaiKhoanNganHang taiKhoanNganHang) {
        List<String> stringList = new ArrayList<>();
        stringList.add(taiKhoanNganHang.getInfoToCSV());
        ReadAndWriteFile.writeToFile(BANK_DATA, stringList, true);
    }

    @Override
    public List<TaiKhoanNganHang> getList() {
        List<String> stringList = readAndWriteFile.readFileCSV(BANK_DATA);
        List<TaiKhoanNganHang> taiKhoanNganHangList = new ArrayList<>();
        String[] array = null;
        for (String s: stringList) {
            array = s.split(",");
            if(array[1].contains("TKThanhToan")) {
                // int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan, String soThe, double soTienTrongTaiKhoan
                int id = Integer.parseInt(array[0]);
                String maTaiKhoan = array[1];
                String tenchuTaiKhoan = array[2];
                String ngaytaoTaiKhoan = array[3];
                String soThe = array[4];
                double soTienTrongTaiKhoan = Double.parseDouble(array[5]);
                TaiKhoanNganHang taiKhoanNganHang = new TaiKhoanThanhToan(id,maTaiKhoan,tenchuTaiKhoan,ngaytaoTaiKhoan,soThe,soTienTrongTaiKhoan);
                taiKhoanNganHangList.add(taiKhoanNganHang);
            } else {
                // int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan, double tienGoi, String ngayGoi, String laiSuat, int kiHan
                int id = Integer.parseInt(array[0]);
                String maTaiKhoan = array[1];
                String tenchuTaiKhoan = array[2];
                String ngaytaoTaiKhoan = array[3];
                double tienGoi = Double.parseDouble(array[4]);
                String ngayGoi = array[5];
                String laiSuat = array[6];
                int kiHan = Integer.parseInt(array[7]);
                TaiKhoanNganHang taiKhoanNganHang = new TaiKhoanTietKiem(id,maTaiKhoan,tenchuTaiKhoan,ngaytaoTaiKhoan,tienGoi,ngayGoi,laiSuat,kiHan);
                taiKhoanNganHangList.add(taiKhoanNganHang);
            }

        }
        return taiKhoanNganHangList;
    }

    @Override
    public void update(List<TaiKhoanNganHang> taiKhoanNganHangList) {
        List<String> stringList = new ArrayList<>();
        for (TaiKhoanNganHang taiKhoanNganHang: taiKhoanNganHangList) {
            stringList.add(taiKhoanNganHang.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile(BANK_DATA, stringList, false);

    }
}

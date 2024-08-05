package TKNganHang.until;

import TKNganHang.model.TaiKhoanThanhToan;
import TKNganHang.model.TaiKhoanTietKiem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    final static String TAIKHOAN_TIETKIEM = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\TKNganHang\\data\\taikhoantietkiem.csv";
    final static String TAIKHOAN_THANHTOAN = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\TKNganHang\\data\\taikhoanthanhtoan.csv ";

    public static List<TaiKhoanTietKiem> ReadtaiKhoanTietKiems() throws IOException {
        List<TaiKhoanTietKiem> tietKiemList = new ArrayList<>();
        FileReader fileReader = new FileReader(TAIKHOAN_TIETKIEM);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] temp;
        TaiKhoanTietKiem tietKiem;
        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            if (temp.length == 8) {
                int id = Integer.parseInt(temp[0].trim());
                String maTaiKhoan = temp[1].trim();
                String tenChuTaiKhoan = temp[2].trim();
                String ngayTaoTaiKhoan = temp[3].trim();
                double soTienGui = Double.parseDouble(temp[4].trim());
                String ngayGui = temp[5].trim();
                String laiSuat = temp[6].trim();
                int kiHan = Integer.parseInt(temp[7].trim());
                tietKiem = new TaiKhoanTietKiem(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan, soTienGui, ngayGui, laiSuat, kiHan);
                tietKiemList.add(tietKiem);
            }else System.out.println("danh sách trống");
        }
        bufferedReader.close();



        return tietKiemList;
    }
    public static List<TaiKhoanThanhToan> ReadtaiKhoanThanhToan() throws IOException {
        List<TaiKhoanThanhToan> thanhToans = new ArrayList<>();
        FileReader fileReader = new FileReader(TAIKHOAN_THANHTOAN);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] temp;
        TaiKhoanThanhToan thanhToan;
        while ((line = bufferedReader.readLine()) != null){
            temp = line.split(",");
            if (temp.length==6) {
                int id = Integer.parseInt(temp[0].trim());
                String maTaiKhoan = temp[1].trim();
                String tenChuTaiKhoan = temp[2].trim();
                String ngayTaoTaiKhoan = temp[3].trim();
                String soThe = temp[4].trim();
                double soTienTrongTaiKhoan = Double.parseDouble(temp[5]);
                thanhToan = new TaiKhoanThanhToan(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan, soThe, soTienTrongTaiKhoan);
                thanhToans.add(thanhToan);
            }else System.out.println("Danh Sách Trống");
        }
        bufferedReader.close();
        return thanhToans;


    }
    public static void writeTaiKhoanTietKiem(List<TaiKhoanTietKiem> taiKhoanTietKiemList) throws IOException {
        FileWriter fileWriter = new FileWriter(TAIKHOAN_TIETKIEM,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (TaiKhoanTietKiem taiKhoanTietKiem: taiKhoanTietKiemList){
            bufferedWriter.write(taiKhoanTietKiem.getId()+","+taiKhoanTietKiem.getMaTaiKhoan()+","+taiKhoanTietKiem.getTenChuTaiKhoan()+","+taiKhoanTietKiem.getNgayTaoTaiKhoan()+
                    ","+taiKhoanTietKiem.getTienGui()+","+taiKhoanTietKiem.getNgayGui()+","+taiKhoanTietKiem.getLaiSuat()+","+taiKhoanTietKiem.getKiHan() +"\n");
        }

        bufferedWriter.close();
    }
    public static void writeTaiKhoanThanhToan(List<TaiKhoanThanhToan> taiKhoanThanhToanList) throws IOException {
        FileWriter fileWriter = new FileWriter(TAIKHOAN_THANHTOAN,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (TaiKhoanThanhToan taiKhoanThanhToan: taiKhoanThanhToanList){
            bufferedWriter.write(taiKhoanThanhToan.getId()+","+taiKhoanThanhToan.getMaTaiKhoan()+","+taiKhoanThanhToan.getTenChuTaiKhoan()+","+taiKhoanThanhToan.getNgayTaoTaiKhoan()+
                    ","+taiKhoanThanhToan.getSoThe()+","+taiKhoanThanhToan.getSoTienTrongTaiKhoan() +"\n");
        }

        bufferedWriter.close();
    }
}

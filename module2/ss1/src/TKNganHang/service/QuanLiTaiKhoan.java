package TKNganHang.service;

import TKNganHang.model.TaiKhoanThanhToan;
import TKNganHang.model.TaiKhoanTietKiem;
import TKNganHang.until.ReadAndWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLiTaiKhoan {
    static Scanner scanner = new Scanner(System.in);
    static int count = 0;
    public static List<TaiKhoanTietKiem> taiKhoanTietKiemList = new ArrayList<>();
    public static List<TaiKhoanThanhToan> taiKhoanThanhToanList = new ArrayList<>();


    public void displayTietKiem() throws IOException {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = ReadAndWrite.ReadtaiKhoanTietKiems();
        for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiemList){
            System.out.println(taiKhoanTietKiem.toString());
        }


    }
    public void displayThanhToan() throws IOException {
        List<TaiKhoanThanhToan> taiKhoanThanhToanList = ReadAndWrite.ReadtaiKhoanThanhToan();
        for (TaiKhoanThanhToan taiKhoanThanhToan: taiKhoanThanhToanList){
            System.out.println(taiKhoanThanhToan.toString());
        }
    }

    public void addTaiKhoanTietKiem() throws IOException {
        //đọc
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = ReadAndWrite.ReadtaiKhoanTietKiems();
        for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiemList){
            System.out.println(taiKhoanTietKiem.toString());
        }

        //nhập
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã tài khoản:");
        String maTaiKhoan = scanner.nextLine();
        System.out.println("Nhập tên chủ tài khoản");
        String tenTaiKhoan = scanner.nextLine();
        System.out.println("Nhập ngày tạo tài khoản");
        String ngayTao = scanner.nextLine();

        double soTienGui = 0;
        do{
            try{
                System.out.println("Nhập số tiền gửi");
                soTienGui = Double.parseDouble(scanner.nextLine());
                if(soTienGui<0){
                    System.out.println("Vui lòng nhập số lơn hơn 0");
                }

            }catch (NumberFormatException e){
                System.out.println("Vui vòng nhập số");
            }
        }while (soTienGui<0);
//        System.out.println("Nhập số tiền gửi");
//        double tienGui = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập ngày gửi tiết kiệm");
        String ngayGui = scanner.nextLine();
        System.out.println("Nhập lãi suất: ");
        String laiSuat = scanner.nextLine();
        System.out.println("Nhập kì hạn");
        int kiHan = Integer.parseInt(scanner.nextLine());
        TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(id, maTaiKhoan,tenTaiKhoan,ngayTao,soTienGui,ngayGui,laiSuat,kiHan);
        taiKhoanTietKiemList.add(taiKhoanTietKiem);
        //viết
        ReadAndWrite.writeTaiKhoanTietKiem(taiKhoanTietKiemList);
        displayTietKiem();
    }

    public void addTaiKhoanThanhToan() throws IOException {
        //đọc
        List<TaiKhoanThanhToan> taiKhoanThanhToanList = ReadAndWrite.ReadtaiKhoanThanhToan();
        for (TaiKhoanThanhToan taiKhoanThanhToan: taiKhoanThanhToanList){
            System.out.println(taiKhoanThanhToan.toString());
        }
        //viết
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã tài khoản:");
        String maTaiKhoan = scanner.nextLine();
        System.out.println("Nhập tên chủ tài khoản");
        String tenTaiKhoan = scanner.nextLine();
        System.out.println("Nhập ngày tạo tài khoản");
        String ngayTao = scanner.nextLine();
        System.out.println("Nhập số thẻ");
        String soThe = scanner.nextLine();
        System.out.println("Nhập số tiền trong tài khoản");
        double soTienTrongTaiKhoan = Double.parseDouble(scanner.nextLine());
        TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(id,maTaiKhoan,tenTaiKhoan,ngayTao,soThe,soTienTrongTaiKhoan);
        taiKhoanThanhToanList.add(taiKhoanThanhToan);
        //viết
        ReadAndWrite.writeTaiKhoanThanhToan(taiKhoanThanhToanList);
        displayThanhToan();
    }
    public static List<TaiKhoanTietKiem> xoaTietKiem() throws IOException {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = ReadAndWrite.ReadtaiKhoanTietKiems();
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0;i<taiKhoanTietKiemList.size();i++){
            if (id == (taiKhoanTietKiemList.get(i).getId())){
                taiKhoanTietKiemList.remove(taiKhoanTietKiemList.get(i));
                System.out.println("xóa thành công");
                ReadAndWrite.writeTaiKhoanTietKiem(taiKhoanTietKiemList);
//            }else if ((id != (taiKhoanTietKiemList.get(i).getId()))) {
//                System.out.println("Không tìm thấy sản phẩm");
            }
        }
        return taiKhoanTietKiemList;
    }

    public static List<TaiKhoanThanhToan> xoaThanhToan() throws IOException {
        List<TaiKhoanThanhToan> taiKhoanThanhToanList = ReadAndWrite.ReadtaiKhoanThanhToan();
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < taiKhoanThanhToanList.size(); i++) {
            if (id == (taiKhoanThanhToanList.get(i).getId())) {
                taiKhoanThanhToanList.remove(taiKhoanThanhToanList.get(i));
                System.out.println("xóa thành công");
                ReadAndWrite.writeTaiKhoanThanhToan(taiKhoanThanhToanList);
//            }else if ((id != (taiKhoanThanhToanList.get(i).getId()))) {
//                System.out.println("Không tìm thấy sản phẩm");
            }
        }
        return taiKhoanThanhToanList;
    }

    public List<TaiKhoanTietKiem> taiKiemTietKiem() throws IOException {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = ReadAndWrite.ReadtaiKhoanTietKiems();
        System.out.println("Nhập tên hoặc mã cần tìm");
        String name = scanner.nextLine();
        for (int i=0;i<taiKhoanTietKiemList.size();i++){
            if(taiKhoanTietKiemList.get(i).getMaTaiKhoan().contains(name)||taiKhoanTietKiemList.get(i).getTenChuTaiKhoan().contains(name)){
                System.out.println(taiKhoanTietKiemList.get(i));
            }
        }
        return null;
    }

    public List<TaiKhoanThanhToan> timKiemThanhToan() throws IOException {
        List<TaiKhoanThanhToan> taiKhoanThanhToanList = ReadAndWrite.ReadtaiKhoanThanhToan();
        System.out.println("Nhập tên hoặc mã cần tìm");
        String name = scanner.nextLine();
        for (int i =0;i<taiKhoanThanhToanList.size();i++){
            if(taiKhoanThanhToanList.get(i).getMaTaiKhoan().contains(name)||taiKhoanThanhToanList.get(i).getTenChuTaiKhoan().contains(name)){
                System.out.println(taiKhoanThanhToanList.get(i));
            }
        }
        return null;
    }

}

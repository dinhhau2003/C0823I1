package DienThoai1.controller;

import DienThoai1.service.QuanLiDienThoai;
import XuatNhapKhau1.service.QuanLiProduct;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static QuanLiDienThoai quanLiDienThoai = new QuanLiDienThoai();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose;
        String input;
        String chon;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÍ ĐIỆN THOẠI--");
            System.out.println("1.Thêm mới");
            System.out.println("2. Xóa ");
            System.out.println("3.Xem danh sách ");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Thêm mới");
                    System.out.println("Chọn 1:Thêm mới chính hãng");
                    System.out.println("Chọn 2: Thêm mới xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiDienThoai.addChinhHang();
                            break;
                        case "2":
                            quanLiDienThoai.addXachTay();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Xóa");
                    System.out.println("Chọn 1:Xóa chính hãng");
                    System.out.println("Chọn 2: Xóa xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1": {
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanLiDienThoai.xoaChinhHang();
                                    break;
                                case "no":
                                    quanLiDienThoai.displayChinhHang();
                                    break;
                            }
                            break;
                        }
                        case "2":
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanLiDienThoai.xoaXachTay();
                                    break;
                                case "no":
                                    quanLiDienThoai.displayXachTay();
                                    break;
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Hiển Thị");
                    System.out.println("Chọn 1: Hiển thị chính hãng");
                    System.out.println("Chọn 2: Hiển thị xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiDienThoai.displayChinhHang();
                            break;
                        case "2":
                            quanLiDienThoai.displayXachTay();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Tìm Kiếm");
                    System.out.println(" 1.Tìm kiếm chính hãng");
                    System.out.println(" 2. Tìm kiếm xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiDienThoai.taiKiemChinhHang();
                            break;
                        case "2":
                            quanLiDienThoai.timKiemXachTay();
                            break;
                    }
                    break;
                case 5:
                    return;

                default:
                    System.out.println("chọn sai");
                    break;
            }
        }
        while (choose != 5);
    }

}

package XuatNhapKhau1.controller;

import XuatNhapKhau1.service.QuanLiProduct;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static QuanLiProduct quanLiProduct = new QuanLiProduct();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose;
        String input;
        String chon;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÍ PRODUCT--");
            System.out.println("1.Thêm mới");
            System.out.println("2. Xóa ");
            System.out.println("3.Xem danh sách ");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Thêm mới");
                    System.out.println("Chọn 1:Thêm mới nhập khẩu");
                    System.out.println("Chọn 2: Thêm mới xuất khẩu");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiProduct.addNhapKhau();
                            break;
                        case "2":
                            quanLiProduct.addXuatKhau();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Xóa");
                    System.out.println("Chọn 1:Xóa nhập khẩu");
                    System.out.println("Chọn 2: Xóa xuất khẩu");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1": {
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanLiProduct.xoaNhapKhau();
                                    break;
                                case "no":
                                    quanLiProduct.displayNhapKhau();
                                    break;
                            }
                            break;
                        }
                        case "2":
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanLiProduct.xoaXuatKhau();
                                    break;
                                case "no":
                                    quanLiProduct.displayXuatKhau();
                                    break;
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Hiển Thị");
                    System.out.println("Chọn 1: Hiển thị nhập khẩu");
                    System.out.println("Chọn 2: Hiển thị xuất khẩu");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiProduct.displayNhapKhau();
                            break;
                        case "2":
                            quanLiProduct.displayXuatKhau();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Tìm Kiếm");
                    System.out.println(" 1.Tìm kiếm nhập khẩu");
                    System.out.println(" 2. Tìm kiếm xuất khẩu");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiProduct.taiKiemNhapKhau();
                            break;
                        case "2":
                            quanLiProduct.timKiemXuatKhau();
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

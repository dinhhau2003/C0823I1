package ThiModule2.controller;

import ThiModule2.service.QuanLiBenhAn;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static ThiModule2.service.QuanLiBenhAn quanLiBenhAn = new QuanLiBenhAn();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose;
        String input;
        String chon;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÍ BỆNH ÁN--");
            System.out.println("1.Thêm mới");
            System.out.println("2. Xóa ");
            System.out.println("3.Xem danh sách ");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Thêm mới");
                    System.out.println("Chọn 1:Thêm mới bệnh án thường");
                    System.out.println("Chọn 2: Thêm mới bệnh án vip");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiBenhAn.addThuong();
                            break;
                        case "2":
                            quanLiBenhAn.addVip();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Xóa");
                    System.out.println("Chọn 1:Xóa bệnh án thường");
                    System.out.println("Chọn 2: Xóa bệnh án vip");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1": {
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanLiBenhAn.xoaThuong();
                                    break;
                                case "no":
                                    quanLiBenhAn.displayThuong();
                                    break;
                            }
                            break;
                        }
                        case "2":
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanLiBenhAn.xoaVip();
                                    break;
                                case "no":
                                    quanLiBenhAn.displayVip();
                                    break;
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Hiển Thị danh sách");
//                    System.out.println(" Hiển thị danh sách bệnh nhân thường");
                    quanLiBenhAn.displayThuong();
//                    System.out.println(" Hiển thị danh sách bệnh nhân vip");
                    quanLiBenhAn.displayVip();
//                    input = scanner.nextLine();
//                    switch (input) {
//                        case "1":
//
//                            break;
//                        case "2":
//
//                            break;
//                    }
                    break;
                case 4:
                    System.out.println("Tìm Kiếm");
                    System.out.println(" 1.Tìm kiếm bệnh nhân thường");
                    System.out.println(" 2. Tìm kiếm bệnh nhân vip");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanLiBenhAn.timKiemThuong();
                            break;
                        case "2":
                            quanLiBenhAn.timKiemVip();
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

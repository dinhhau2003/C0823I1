package TaiKhoan.controller;

import TaiKhoan.repository.IBankRepository;
import TaiKhoan.service.BankService;
import TaiKhoan.service.IBankService;
import TaiKhoan.until.CheckInputData;

import java.util.Scanner;

public class BankController {
   private static IBankService bankService=new BankService();
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÍ TÀI KHOẢN NGÂN HÀNG--");
            System.out.println("1.Thêm mới");
            System.out.println("2. Xóa ");
            System.out.println("3.Xem danh sách các tài khoản ngân hàng");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");
            int choice = CheckInputData.CheckInputOption("Chọn chức năng:", 1, 5);
            switch (choice) {
                case 1: {
                    bankService.addBank();
                    break;
                }
                case 2: {
                    int idBankDel = CheckInputData.checkInputInt("Nhập id ngân hàng cần xóa:",0, "Id");
                    bankService.removeBank(idBankDel);
                    break;

                }
                case 3: {
                    bankService.displayBank();
                    break;

                }
                case 4: {
                    String nameFind = BankController.findByName();
                    bankService.findBank(nameFind);
                    break;

                }
                default: {
                    flag = false;
                }

            }
        } while (flag);
    }
    public static String findByName() {

        return CheckInputData.checkInputNull("Nhập tên chủ tài khoản cần tìm: ", "Tên ngân hàng");
    }
}

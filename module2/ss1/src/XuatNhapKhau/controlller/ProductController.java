package XuatNhapKhau.controlller;

import XuatNhapKhau.service.IProductService;
import XuatNhapKhau.service.ProductService;
import XuatNhapKhau.until.CheckInputData;

import java.util.Scanner;

public class ProductController {
    private static IProductService productService = new ProductService();
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("1.Thêm mới.");
            System.out.println("2.Xóa.");
            System.out.println("3.Xem danh sách các sản phẩm.");
            System.out.println("4.Tìm kiếm.");
            System.out.println("5.Thoát.");
            int choice = CheckInputData.CheckInputOption("Chọn chức năng:", 1, 5);
            switch (choice) {
                case 1: {
                    productService.addProduct();
                    break;
                }
                case 2: {
                    String maProductDel = CheckInputData.checkInputNull("Nhập mã sản phẩm cần xóa:", "Mã sản phẩm");
                    productService.removeProduct(maProductDel);
                    break;

                }
                case 3: {
                    productService.displayProduct();
                    break;

                }
                case 4: {
                    String nameFind = ProductController.findByName();
                    productService.findProduct(nameFind);
                    break;

                }
                default: {
                    flag = false;
                }

            }
        } while (flag);
    }
    public static String findByName() {

        return CheckInputData.checkInputNull("Nhập tên sản phẩm cần tìm: ", "Tên sản phẩm");
    }
}

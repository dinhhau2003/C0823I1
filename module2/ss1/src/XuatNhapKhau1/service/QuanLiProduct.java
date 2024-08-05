package XuatNhapKhau1.service;

import XuatNhapKhau1.model.ProductNhapKhau;
import XuatNhapKhau1.model.ProductXuatKhau;
import XuatNhapKhau1.until.ReadAndWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuanLiProduct {
    static Scanner scanner;
    static int count;
    public static List<ProductNhapKhau> productNhapKhauList;
    public static List<ProductXuatKhau> productXuatKhauList;

    public QuanLiProduct() {
    }

    public void displayNhapKhau() throws IOException {
        List<ProductNhapKhau> productNhapKhauList = ReadAndWrite.ReadNhapKhau();
        Iterator var2 = productNhapKhauList.iterator();

        while(var2.hasNext()) {
            ProductNhapKhau productNhapKhau = (ProductNhapKhau) var2.next();
            System.out.println(productNhapKhau.toString());
        }

    }

    public void displayXuatKhau() throws IOException {
        List<ProductXuatKhau> productXuatKhauList = ReadAndWrite.ReadXuatKhau();
        Iterator var2 = productXuatKhauList.iterator();

        while(var2.hasNext()) {
            ProductXuatKhau productXuatKhau = (ProductXuatKhau) var2.next();
            System.out.println(productXuatKhau.toString());
        }

    }

    public void addNhapKhau() throws IOException {
        List<ProductNhapKhau> productNhapKhauList = ReadAndWrite.ReadNhapKhau();
        Iterator var2 = productNhapKhauList.iterator();

        while(var2.hasNext()) {
            ProductNhapKhau productNhapKhau = (ProductNhapKhau) var2.next();
            System.out.println(productNhapKhau.toString());
        }

        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã product:");
        String maProduct = scanner.nextLine();
        System.out.println("Nhập tên product");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập giá");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng");
        int quantity=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String nhaSanXuat=scanner.nextLine();
        System.out.println("Nhập tác giả");
        String tacgia=scanner.nextLine();
        System.out.println("Nhập giá nhập khẩu");
        double priceNK=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập province");
        String province=scanner.nextLine();
        System.out.println("Thuế nhập khẩu");
        double thueNK=Double.parseDouble(scanner.nextLine());
       ProductNhapKhau productNhapKhau=new ProductNhapKhau(id,maProduct,nameProduct,price,quantity,nhaSanXuat,tacgia,priceNK,province,thueNK);
       productNhapKhauList.add(productNhapKhau);
       ReadAndWrite.writeNhapKhau(productNhapKhauList);
        this.displayNhapKhau();
    }

    public void addXuatKhau() throws IOException {
        List<ProductXuatKhau> productXuatKhauList = ReadAndWrite.ReadXuatKhau();
        Iterator var2 = productXuatKhauList.iterator();

        while(var2.hasNext()) {
            ProductXuatKhau productXuatKhau = (ProductXuatKhau) var2.next();
            System.out.println(productXuatKhau.toString());
        }

        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã product:");
        String maProduct = scanner.nextLine();
        System.out.println("Nhập tên product");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập giá");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng");
        int quantity=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String nhaSanXuat=scanner.nextLine();
        System.out.println("Nhập tác giả");
        String tacgia=scanner.nextLine();
        System.out.println("Nhập giá xuất khẩu");
        double priceXK=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập quốc tịch");
        String national=scanner.nextLine();
        ProductXuatKhau productXuatKhau=new ProductXuatKhau(id,maProduct,nameProduct,price,quantity,nhaSanXuat,tacgia,priceXK,national);
        productXuatKhauList.add(productXuatKhau);
        ReadAndWrite.writeXuatKhau(productXuatKhauList);
        this.displayXuatKhau();
    }

    public static List<ProductNhapKhau> xoaNhapKhau() throws IOException {
        List<ProductNhapKhau> productNhapKhauList = ReadAndWrite.ReadNhapKhau();
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i <productNhapKhauList.size(); ++i) {
            if (id == ((ProductNhapKhau)productNhapKhauList.get(i)).getId()) {
                productNhapKhauList.remove(productNhapKhauList.get(i));
                System.out.println("xóa thành công");
                ReadAndWrite.writeNhapKhau(productNhapKhauList);
            }
        }

        return productNhapKhauList;
    }

    public static List<ProductXuatKhau> xoaXuatKhau() throws IOException {
        List<ProductXuatKhau> productXuatKhauList = ReadAndWrite.ReadXuatKhau();
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < productXuatKhauList.size(); ++i) {
            if (id == ((ProductXuatKhau)productXuatKhauList.get(i)).getId()) {
                productXuatKhauList.remove(productXuatKhauList.get(i));
                System.out.println("xóa thành công");
                ReadAndWrite.writeXuatKhau(productXuatKhauList);
            }
        }

        return productXuatKhauList;
    }

    public List<ProductNhapKhau> taiKiemNhapKhau() throws IOException {
        List<ProductNhapKhau> productNhapKhauList = ReadAndWrite.ReadNhapKhau();
        System.out.println("Nhập tên hoặc mã cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i < productNhapKhauList.size(); ++i) {
            if (((ProductNhapKhau)productNhapKhauList.get(i)).getMaProduct().contains(name) || ((ProductNhapKhau)productNhapKhauList.get(i)).getNameProduct().contains(name)) {
                System.out.println(productNhapKhauList.get(i));
            }
        }

        return null;
    }

    public List<ProductXuatKhau> timKiemXuatKhau() throws IOException {
        List<ProductXuatKhau> productXuatKhauList = ReadAndWrite.ReadXuatKhau();
        System.out.println("Nhập tên hoặc mã cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i <productXuatKhauList.size(); ++i) {
            if (((ProductXuatKhau)productXuatKhauList.get(i)).getNameProduct().contains(name) || ((ProductXuatKhau)productXuatKhauList.get(i)).getMaProduct().contains(name)) {
                System.out.println(productXuatKhauList.get(i));
            }
        }

        return null;
    }

    static {
        scanner = new Scanner(System.in);
        count = 0;
        productNhapKhauList = new ArrayList();
        productXuatKhauList = new ArrayList();
    }
}

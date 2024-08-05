package XuatNhapKhau.service;

import XuatNhapKhau.model.Product;
import XuatNhapKhau.model.ProductNhapKhau;
import XuatNhapKhau.model.ProductXuatKhau;
import XuatNhapKhau.repository.IProductRepository;
import XuatNhapKhau.repository.ProductRepository;
import XuatNhapKhau.until.CheckInputData;
import XuatNhapKhau.until.Validation;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static IProductRepository productRepository = new ProductRepository();
    @Override
    public void addProduct() {
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng thêm loại sản phẩm:");
            System.out.println("1.Thêm sản phẩm nhập khẩu.");
            System.out.println("2.Thêm sản phẩm xuất khẩu.");
            System.out.println("3.Back to menu.");
            int choice = CheckInputData.CheckInputOption("Mời bạn nhập chức năng thêm:", 1, 3);
            switch (choice) {
                case 1: {
                    addProductNK();
                    break;
                }
                case 2: {
                    addProductXK();
                    break;
                }
                default: {
                    flag = false;

                }
            }
        } while (flag);
    }

    public void addProductXK() {
        while (true) {
            // int id, String maProduct, String nameProduct, double price, int quantity, String nhaSanXuat, double priceXK, String national
            int id = CheckInputData.checkInputInt("Mời bạn nhập id sản phẩm:", 0);
            String maProduct = CheckInputData.checkInputNull("Mời bạn nhập mã sản phẩm:", "Mã sản phẩm");
            String nameProduct = CheckInputData.checkInputNull("Mời bạn nhập tên sản phẩm:","teen sanpham");
            double price = CheckInputData.checkInputDouble("Nhập giá bán sản phẩm:", 0 , "Giá bán");
            int quantity = CheckInputData.checkInputInt("Mời bạn nhập số lượng sản phẩm:", 0);
            String nhaSanXuat = CheckInputData.checkInputNull("Mời bạn nhập nhà sản xuất:", "Nhà sản xuất");
            String tacGia = CheckInputData.checkInputNull("Mời bạn nhập tác giả:", "tác giả");
            double priceXK = CheckInputData.checkInputDouble("Mời bạn nhập giá xuất khẩu", 0, "Giá xuất khẩu");
            String national = CheckInputData.checkInputNull("Mời bạn nhập quốc gia:", "Tên quốc gia");
            ProductXuatKhau productXuatKhau = new ProductXuatKhau(id, maProduct, nameProduct, price, quantity, nhaSanXuat,tacGia, priceXK, national);
            productRepository.addProduct(productXuatKhau);
            System.out.println("Đã thêm thành công.");
            String mess = "Bạn có muốn thêm nữa không?(Y/N)";
            if (Validation.confirm(mess)) {
                continue;
            } else {
                return;
            }
        }
    }


    public void addProductNK() {
        while (true) {
            // int id, String maProduct, String nameProduct, double price, int quantity, String nhaSanXuat, double priceNK, String province, double thueNK
            int id = CheckInputData.checkInputInt("Mời bạn nhập id sản phẩm:", 0);
            String maProduct = CheckInputData.checkInputNull("Mời bạn nhập mã sản phẩm:", "Mã sản phẩm");
            String nameProduct = CheckInputData.checkInputnameProductNK("Mời bạn nhập tên sản phẩm:");
            double price = CheckInputData.checkInputDouble("Nhập giá bán sản phẩm:", 0 , "Giá bán");
            int quantity = CheckInputData.checkInputInt("Mời bạn nhập số lượng sản phẩm:", 0);
            String nhaSanXuat = CheckInputData.checkInputNull("Mời bạn nhập nhà sản xuất:", "Nhà sản xuất");
            String tacGia = CheckInputData.checkInputNull("Mời bạn nhập tác giả:", "tác giả");
            double priceNK = CheckInputData.checkInputDouble("Nhập giá nhập khẩu sản phẩm:", 0, "Giá nhập khẩu");
            String province = CheckInputData.checkInputNull("Mời bạn nhập tỉnh thành:", "Tỉnh thành");
            double thueNK = CheckInputData.checkInputDouble("Nhập giá thuế nhập khẩu:", 0, "Thuế nhập khẩu");
            ProductNhapKhau productNhapKhau = new ProductNhapKhau(id, maProduct, nameProduct, price, quantity, nhaSanXuat,tacGia, priceNK, province, thueNK);
            productRepository.addProduct(productNhapKhau);
            System.out.println("Đã thêm thành công.");

            String mess = "Bạn có muốn thêm nữa không?(Y/N)";
            if (Validation.confirm(mess)) {
                continue;
            } else {
                return;
            }
        }
    }

    @Override
    public void displayProduct() {
        List<Product> productList = productRepository.getList();
        for (Product product : productList) {
            System.out.println(product.getInfoToCSV());
        }
    }

    @Override
    public void removeProduct(String maProductDel) {
        List<Product> productList = productRepository.getList();
        List<String> stringList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().equals(maProductDel)) {
                flag = true;
                System.out.println("Đã tìm thấy sản phẩm tương ứng");
                String mess = "Bạn có muốn chắc chắn xóa không?(Y/N)";
                if (Validation.confirm(mess)) {
                    productList.remove(i);
                    productRepository.update(productList);
                    System.out.println("Đã xóa thành công!!!");
                    return;
                }
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    @Override
    public void findProduct(String nameFind) {
        boolean flag = false;
        List<Product> productList = productRepository.getList();
        for (Product product : productList) {
            if (product.getMaProduct().equals(nameFind)) {
                flag = true;
                System.out.println("Đã tìm thấy tên sản phẩm.");
                System.out.println(product);
                break;
            }

        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }
}

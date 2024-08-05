package XuatNhapKhau.repository;

import XuatNhapKhau.model.Product;
import XuatNhapKhau.model.ProductNhapKhau;
import XuatNhapKhau.model.ProductXuatKhau;
import XuatNhapKhau.until.ReadAndWriteFileToCSV;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static ReadAndWriteFileToCSV readAndWriteFileToCSV = new ReadAndWriteFileToCSV();
    private final String PRODUCT_DATA = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\XuatNhapKhau\\data\\data.csv";
    @Override
    public void addProduct(Product product) {
        List<String> stringList = new ArrayList<>();
        stringList.add(product.getInfoToCSV());
        ReadAndWriteFileToCSV.writeToFile(PRODUCT_DATA, stringList, true);
    }

    @Override
    public List<Product> getList() {
        List<String> stringList = readAndWriteFileToCSV.readFileCSV(PRODUCT_DATA);
        List<Product> productList = new ArrayList<>();
        String[] array = null;
        for (String s: stringList) {
            array = s.split(",");
            if(array[2].contains("Giay Adidas") || array[2].contains("Dong ho Rolex") || array[2].contains("Iphone XS")) {
                // int id, String maProduct, String nameProduct, double price, int quantity, String nhaSanXuat, double priceNK, String province, double thueNK
                int id = Integer.parseInt(array[0]);
                String maProduct = array[1];
                String nameproduct = array[2];
                double price = Double.parseDouble(array[3]);
                int quantity = Integer.parseInt(array[4]);
                String nhaSanXuat = array[5];
                String tacGia = array[6];
                double priceNK = Double.parseDouble(array[7]);
                String province = array[8];
                double thueNK = Double.parseDouble(array[9]);
                Product product = new ProductNhapKhau(id,maProduct,nameproduct,price,quantity,nhaSanXuat,tacGia,priceNK,province,thueNK);
                productList.add(product);
            } else {
                // int id, String maProduct, String nameProduct, double price, int quantity, String nhaSanXuat, double priceXK, String national)
                int id = Integer.parseInt(array[0]);
                String maProduct = array[1];
                String nameproduct = array[2];
                double price = Double.parseDouble(array[3]);
                int quantity = Integer.parseInt(array[4]);
                String nhaSanXuat = array[5];
                String tacGia = array[6];
                double priceXK = Double.parseDouble(array[7]);
                String national = array[8];
                Product product = new ProductXuatKhau(id,maProduct,nameproduct,price,quantity,nhaSanXuat,tacGia,priceXK,national);
                productList.add(product);
            }

        }
        return productList;
    }

    @Override
    public void update(List<Product> productList) {
        List<String> stringList = new ArrayList<>();
        for (Product product: productList) {
            stringList.add(product.getInfoToCSV());
        }
        ReadAndWriteFileToCSV.writeToFile(PRODUCT_DATA, stringList, false);
    }
    }


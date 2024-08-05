package XuatNhapKhau1.until;

import XuatNhapKhau1.model.ProductNhapKhau;
import XuatNhapKhau1.model.ProductXuatKhau;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndWrite {
    static final String NHAP_KHAU = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\XuatNhapKhau1\\data\\nhapkhau.csv";
    static final String XUAT_KHAU = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\XuatNhapKhau1\\data\\xuatkhau.csv";

    public ReadAndWrite() {
    }

    public static List<ProductNhapKhau> ReadNhapKhau() throws IOException {
        List<ProductNhapKhau> nhapKhauList = new ArrayList();
        FileReader fileReader = new FileReader(NHAP_KHAU);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            if(temp.length == 10) {
                int id = Integer.parseInt(temp[0].trim());
                String maProduct = temp[1].trim();
                String nameProduct = temp[2].trim();
                double price = Double.parseDouble(temp[3].trim());
                int quantity = Integer.parseInt(temp[4].trim());
                String nhaSanXuat= temp[5].trim();
                String tacGia = temp[6].trim();
                double priceNK = Double.parseDouble(temp[7].trim());
                String province = temp[8].trim();
                double thueNK = Double.parseDouble(temp[9].trim());
                ProductNhapKhau nhapKhau=new ProductNhapKhau(id,maProduct,nameProduct,price,quantity,nhaSanXuat,tacGia,priceNK,province,thueNK);
                nhapKhauList.add(nhapKhau);
            } else {
                System.out.println("Danh sách trống");
            }

        }

        bufferedReader.close();
        return nhapKhauList;
    }

    public static List<ProductXuatKhau> ReadXuatKhau() throws IOException {
        List<ProductXuatKhau> xuatKhauList = new ArrayList();
        FileReader fileReader = new FileReader(XUAT_KHAU);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            if(temp.length == 9) {
                int id = Integer.parseInt(temp[0].trim());
                String maProduct = temp[1].trim();
                String nameProduct = temp[2].trim();
                double price = Double.parseDouble(temp[3].trim());
                int quantity = Integer.parseInt(temp[4].trim());
                String nhaSanXuat= temp[5].trim();
                String tacGia = temp[6].trim();
                double priceXK = Double.parseDouble(temp[7].trim());
                String national = temp[8].trim();
                ProductXuatKhau productXuatKhau=new ProductXuatKhau(id,maProduct,nameProduct,price,quantity,nhaSanXuat,tacGia,priceXK,national);
                xuatKhauList.add(productXuatKhau);
            } else {
                System.out.println("Danh sách trống");
            }

        }

        bufferedReader.close();
        return xuatKhauList;
    }

    public static void writeNhapKhau(List<ProductNhapKhau> productNhapKhauList) throws IOException {
        FileWriter fileWriter = new FileWriter(NHAP_KHAU, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = productNhapKhauList.iterator();

        while(var3.hasNext()) {
            ProductNhapKhau productNhapKhau = (ProductNhapKhau) var3.next();
            bufferedWriter.write(productNhapKhau.getId() + "," + productNhapKhau.getMaProduct() + "," + productNhapKhau.getNameProduct() + "," + productNhapKhau.getPrice() + "," + productNhapKhau.getQuantity() + "," +productNhapKhau.getNhaSanXuat() + "," + productNhapKhau.getTacgia() + "," + productNhapKhau.getPriceNK()+","+productNhapKhau.getProvince()+","+productNhapKhau.getThueNK() + "\n");
        }

        bufferedWriter.close();
    }

    public static void writeXuatKhau(List<ProductXuatKhau> productXuatKhauList) throws IOException {
        FileWriter fileWriter = new FileWriter(XUAT_KHAU, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = productXuatKhauList.iterator();

        while(var3.hasNext()) {
            ProductXuatKhau productXuatKhau = (ProductXuatKhau) var3.next();
            bufferedWriter.write(productXuatKhau.getId() + "," + productXuatKhau.getMaProduct() + "," + productXuatKhau.getNameProduct() + "," + productXuatKhau.getPrice() + "," + productXuatKhau.getQuantity() + "," +productXuatKhau.getNhaSanXuat() + "," + productXuatKhau.getTacgia() + "," + productXuatKhau.getPriceXK()+","+productXuatKhau.getNational()+ "\n");
        }

        bufferedWriter.close();
    }
}

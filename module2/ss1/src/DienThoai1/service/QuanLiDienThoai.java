package DienThoai1.service;

import DienThoai1.model.DienThoaiChinhHang;
import DienThoai1.model.DienThoaiXachTay;
import DienThoai1.until.ReadAndWrite;
import XuatNhapKhau1.model.ProductNhapKhau;
import XuatNhapKhau1.model.ProductXuatKhau;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuanLiDienThoai {
    static Scanner scanner;
    static int count;
    public static List<DienThoaiChinhHang> dienThoaiChinhHangList;
    public static List<DienThoaiXachTay> dienThoaiXachTayList;

    public QuanLiDienThoai() {
    }

    public void displayChinhHang() throws IOException {
        List<DienThoaiChinhHang> dienThoaiChinhHangList = DienThoai1.until.ReadAndWrite.ReadChinhHang();
        Iterator var2 = dienThoaiChinhHangList.iterator();

        while(var2.hasNext()) {
            DienThoaiChinhHang dienThoaiChinhHang = (DienThoaiChinhHang) var2.next();
            System.out.println(dienThoaiChinhHang.toString());
        }

    }

    public void displayXachTay() throws IOException {
        List<DienThoaiXachTay> dienThoaiXachTayList = DienThoai1.until.ReadAndWrite.ReadXachTay();
        Iterator var2 = dienThoaiXachTayList.iterator();

        while(var2.hasNext()) {
            DienThoaiXachTay dienThoaiXachTay = (DienThoaiXachTay) var2.next();
            System.out.println(dienThoaiXachTay.toString());
        }

    }

    public void addChinhHang() throws IOException {
        List<DienThoaiChinhHang> dienThoaiChinhHangList = DienThoai1.until.ReadAndWrite.ReadChinhHang();
        Iterator var2 = dienThoaiChinhHangList.iterator();

        while(var2.hasNext()) {
            DienThoaiChinhHang dienThoaiChinhHang = (DienThoaiChinhHang) var2.next();
            System.out.println(dienThoaiChinhHang.toString());
        }

        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên điện thoại:");
        String tenDienThoai = scanner.nextLine();
        System.out.println("Nhập giá");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String nhaSanXuat = scanner.nextLine();
        System.out.println("Nhập thời gian bảo hành");
        int thoiGianBaoHanh = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập phạm vi bảo hành");
        String phamViBaoHanh = scanner.nextLine();
        DienThoaiChinhHang dienThoaiChinhHang=new DienThoaiChinhHang(id,tenDienThoai,gia,soLuong,nhaSanXuat,thoiGianBaoHanh,phamViBaoHanh);
        dienThoaiChinhHangList.add(dienThoaiChinhHang);
        DienThoai1.until.ReadAndWrite.writeChinhHang(dienThoaiChinhHangList);
        this.displayChinhHang();
    }

    public void addXachTay() throws IOException {
        List<DienThoaiXachTay> dienThoaiXachTayList = DienThoai1.until.ReadAndWrite.ReadXachTay();
        Iterator var2 = dienThoaiXachTayList.iterator();

        while(var2.hasNext()) {
            DienThoaiXachTay dienThoaiXachTay = (DienThoaiXachTay) var2.next();
            System.out.println(dienThoaiXachTay.toString());
        }

        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên điện thoại:");
        String tenDienThoai = scanner.nextLine();
        System.out.println("Nhập giá");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String nhaSanXuat = scanner.nextLine();
        System.out.println("Nhập quốc gia");
        String quocGia = scanner.nextLine();
        System.out.println("Nhập trạng thái");
        String trangThai = scanner.nextLine();
        DienThoaiXachTay dienThoaiXachTay=new DienThoaiXachTay(id,tenDienThoai,gia,soLuong,nhaSanXuat,quocGia,trangThai);
        dienThoaiXachTayList.add(dienThoaiXachTay);
        DienThoai1.until.ReadAndWrite.writeXachTay(dienThoaiXachTayList);
        this.displayXachTay();
    }

    public static List<DienThoaiChinhHang> xoaChinhHang() throws IOException {
        List<DienThoaiChinhHang> dienThoaiChinhHangList = DienThoai1.until.ReadAndWrite.ReadChinhHang();
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i <dienThoaiChinhHangList.size(); ++i) {
            if (id == ((DienThoaiChinhHang)dienThoaiChinhHangList.get(i)).getId()) {
                dienThoaiChinhHangList.remove(dienThoaiChinhHangList.get(i));
                System.out.println("xóa thành công");
                DienThoai1.until.ReadAndWrite.writeChinhHang(dienThoaiChinhHangList);
            }
        }

        return dienThoaiChinhHangList;
    }

    public static List<DienThoaiXachTay> xoaXachTay() throws IOException {
        List<DienThoaiXachTay> dienThoaiXachTayList = DienThoai1.until.ReadAndWrite.ReadXachTay();
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < dienThoaiXachTayList.size(); ++i) {
            if (id == ((DienThoaiXachTay)dienThoaiXachTayList.get(i)).getId()) {
                dienThoaiXachTayList.remove(dienThoaiXachTayList.get(i));
                System.out.println("xóa thành công");
                DienThoai1.until.ReadAndWrite.writeXachTay(dienThoaiXachTayList);
            }
        }

        return dienThoaiXachTayList;
    }

    public List<DienThoaiChinhHang> taiKiemChinhHang() throws IOException {
        List<DienThoaiChinhHang> dienThoaiChinhHangList = DienThoai1.until.ReadAndWrite.ReadChinhHang();
        System.out.println("Nhập tên điện thoại cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i < dienThoaiChinhHangList.size(); ++i) {
            if (((DienThoaiChinhHang)dienThoaiChinhHangList.get(i)).getTenDienThoai().contains(name)) {
                System.out.println(dienThoaiChinhHangList.get(i));
            }
        }

        return null;
    }

    public List<DienThoaiXachTay> timKiemXachTay() throws IOException {
        List<DienThoaiXachTay> dienThoaiXachTayList = ReadAndWrite.ReadXachTay();
        System.out.println("Nhập tên điện thoại cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i <dienThoaiXachTayList.size(); ++i) {
            if (((DienThoaiXachTay)dienThoaiXachTayList.get(i)).getTenDienThoai().contains(name)) {
                System.out.println(dienThoaiXachTayList.get(i));
            }
        }

        return null;
    }

    static {
        scanner = new Scanner(System.in);
        count = 0;
        dienThoaiChinhHangList = new ArrayList();
        dienThoaiXachTayList = new ArrayList();
    }
}

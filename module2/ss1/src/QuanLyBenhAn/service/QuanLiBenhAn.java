package QuanLyBenhAn.service;

import QuanLyBenhAn.model.BenhAnThuong;
import QuanLyBenhAn.model.BenhAnVip;
import QuanLyBenhAn.until.ReadAndWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuanLiBenhAn {
    static Scanner scanner;
    static int count;
    public static List<BenhAnThuong> benhAnThuongList;
    public static List<BenhAnVip> benhAnVipList;

    public QuanLiBenhAn() {
    }

    public void displayThuong() throws IOException {
        List<BenhAnThuong> benhAnThuongList = QuanLyBenhAn.until.ReadAndWrite.ReadThuong();
        Iterator var2 = benhAnThuongList.iterator();

        while(var2.hasNext()) {
            BenhAnThuong benhAnThuong = (BenhAnThuong) var2.next();
            System.out.println(benhAnThuong.toString());
        }

    }

    public void displayVip() throws IOException {
        List<BenhAnVip> benhAnVipList = QuanLyBenhAn.until.ReadAndWrite.ReadVip();
        Iterator var2 = benhAnVipList.iterator();

        while(var2.hasNext()) {
            BenhAnVip benhAnVip = (BenhAnVip) var2.next();
            System.out.println(benhAnVip.toString());
        }

    }

    public void addThuong() throws IOException {
        List<BenhAnThuong> benhAnThuongList = QuanLyBenhAn.until.ReadAndWrite.ReadThuong();
        Iterator var2 = benhAnThuongList.iterator();

        while(var2.hasNext()) {
            BenhAnThuong benhAnThuong = (BenhAnThuong) var2.next();
            System.out.println(benhAnThuong.toString());
        }
//        int count=0;
        System.out.println("Nhập số thứ tự");
        int soThuTu = Integer.parseInt(scanner.nextLine());
//        int soThuTu=count++;
        System.out.println("Nhập mã bệnh án:");
        int maBenhAn = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã bệnh nhân:");
        String maBenhNhan = scanner.nextLine();
        System.out.println("Nhập tên bệnh nhân:");
        String tenBenhNhan = scanner.nextLine();
        System.out.println("Nhập ngày nhập viện:");
        String ngayNhapVien = scanner.nextLine();
        System.out.println("Nhập ngày ra viện:");
        String ngayRaVien = scanner.nextLine();
        System.out.println("Nhập lý do nhập viện:");
        String lyDoNhapVien = scanner.nextLine();
        System.out.println("Nhập phí nằm viện:");
        double phiNamVien=Double.parseDouble(scanner.nextLine());
        BenhAnThuong benhAnThuong=new BenhAnThuong(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,phiNamVien);
        benhAnThuongList.add(benhAnThuong);
        QuanLyBenhAn.until.ReadAndWrite.writeThuong(benhAnThuongList);
        this.displayThuong();
    }

    public void addVip() throws IOException {
        List<BenhAnVip> benhAnVipList = QuanLyBenhAn.until.ReadAndWrite.ReadVip();
        Iterator var2 = benhAnVipList.iterator();

        while(var2.hasNext()) {
            BenhAnVip benhAnVip = (BenhAnVip) var2.next();
            System.out.println(benhAnVip.toString());
        }

        System.out.println("Nhập số thứ tự");
        int soThuTu = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã bệnh án:");
        int maBenhAn = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã bệnh nhân:");
        String maBenhNhan = scanner.nextLine();
        System.out.println("Nhập tên bệnh nhân:");
        String tenBenhNhan = scanner.nextLine();
        System.out.println("Nhập ngày nhập viện:");
        String ngayNhapVien = scanner.nextLine();
        System.out.println("Nhập ngày ra viện:");
        String ngayRaVien = scanner.nextLine();
        System.out.println("Nhập lý do nhập viện:");
        String lyDoNhapVien = scanner.nextLine();
        System.out.println("Nhập loại vip");
        String loaiVip=scanner.nextLine();
        System.out.println("nhập thời hạn vip");
        String thoiHanVip=scanner.nextLine();
        BenhAnVip benhAnVip=new BenhAnVip(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,loaiVip,thoiHanVip);
        benhAnVipList.add(benhAnVip);
        QuanLyBenhAn.until.ReadAndWrite.writeVip(benhAnVipList);
        this.displayVip();
    }

    public static List<BenhAnThuong> xoaThuong() throws IOException {
        List<BenhAnThuong> benhAnThuongList = QuanLyBenhAn.until.ReadAndWrite.ReadThuong();
        System.out.println("Nhập số thứ tự cần xóa");
        int maBenhAn = Integer.parseInt(scanner.nextLine());
            String name=scanner.nextLine();
        for(int i = 0; i <benhAnThuongList.size(); ++i) {
            if (maBenhAn == ((BenhAnThuong)benhAnThuongList.get(i)).getMaBenhAn()) {
                benhAnThuongList.remove(benhAnThuongList.get(i));
                System.out.println("xóa thành công");
                QuanLyBenhAn.until.ReadAndWrite.writeThuong(benhAnThuongList);
            }
        }

        return benhAnThuongList;
    }

    public static List<BenhAnVip> xoaVip() throws IOException {
        List<BenhAnVip> benhAnVipList = QuanLyBenhAn.until.ReadAndWrite.ReadVip();
        System.out.println("Nhập số thứ tự cần xóa");
        int maBenhAn = Integer.parseInt(scanner.nextLine());
        String name=scanner.nextLine();
        for(int i = 0; i < benhAnVipList.size(); ++i) {
            if (maBenhAn == ((BenhAnVip)benhAnVipList.get(i)).getMaBenhAn()) {
                benhAnVipList.remove(benhAnVipList.get(i));
                System.out.println("xóa thành công");
               QuanLyBenhAn.until.ReadAndWrite.writeVip(benhAnVipList);
            }
        }

        return benhAnVipList;
    }

    public List<BenhAnThuong> taiKiemThuong() throws IOException {
        List<BenhAnThuong> benhAnThuongList = QuanLyBenhAn.until.ReadAndWrite.ReadThuong();
        System.out.println("Nhập tên bệnh nhân cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i < benhAnThuongList.size(); ++i) {
            if (((BenhAnThuong)benhAnThuongList.get(i)).getTenBenhNhan().contains(name)) {
                System.out.println(benhAnThuongList.get(i));
            }
        }

        return null;
    }

    public List<BenhAnVip> timKiemVip() throws IOException {
        List<BenhAnVip> benhAnVipList = ReadAndWrite.ReadVip();
        System.out.println("Nhập tên bệnh nhân cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i <benhAnVipList.size(); ++i) {
            if (((BenhAnVip)benhAnVipList.get(i)).getTenBenhNhan().contains(name)) {
                System.out.println(benhAnVipList.get(i));
            }
        }

        return null;
    }

    static {
        scanner = new Scanner(System.in);
        count = 0;
        benhAnThuongList = new ArrayList();
        benhAnVipList = new ArrayList();
    }
}

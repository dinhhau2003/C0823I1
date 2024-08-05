package ThiModule2.service;

import ThiModule2.model.BenhAnThuong;
import ThiModule2.model.BenhAnVip;
import ThiModule2.until.ReadAndWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuanLiBenhAn {
    static Scanner scanner;
    static int count;
    public static List<ThiModule2.model.BenhAnThuong> benhAnThuongList;
    public static List<ThiModule2.model.BenhAnVip> benhAnVipList;

    public QuanLiBenhAn() {
    }

    public void displayThuong() throws IOException {
        List<ThiModule2.model.BenhAnThuong> benhAnThuongList = ThiModule2.until.ReadAndWrite.ReadThuong();
        Iterator var2 = benhAnThuongList.iterator();

        while(var2.hasNext()) {
            ThiModule2.model.BenhAnThuong benhAnThuong = (ThiModule2.model.BenhAnThuong) var2.next();
            System.out.println(benhAnThuong.toString());
        }

    }

    public void displayVip() throws IOException {
        List<ThiModule2.model.BenhAnVip> benhAnVipList = ThiModule2.until.ReadAndWrite.ReadVip();
        Iterator var2 = benhAnVipList.iterator();

        while(var2.hasNext()) {
            ThiModule2.model.BenhAnVip benhAnVip = (ThiModule2.model.BenhAnVip) var2.next();
            System.out.println(benhAnVip.toString());
        }

    }

    public void addThuong() throws IOException {
        List<ThiModule2.model.BenhAnThuong> benhAnThuongList = ThiModule2.until.ReadAndWrite.ReadThuong();
        Iterator var2 = benhAnThuongList.iterator();

        while(var2.hasNext()) {
            ThiModule2.model.BenhAnThuong benhAnThuong = (ThiModule2.model.BenhAnThuong) var2.next();
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
        ThiModule2.model.BenhAnThuong benhAnThuong=new ThiModule2.model.BenhAnThuong(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,phiNamVien);
        benhAnThuongList.add(benhAnThuong);
        ThiModule2.until.ReadAndWrite.writeThuong(benhAnThuongList);
        this.displayThuong();
    }

    public void addVip() throws IOException {
        List<ThiModule2.model.BenhAnVip> benhAnVipList = ThiModule2.until.ReadAndWrite.ReadVip();
        Iterator var2 = benhAnVipList.iterator();

        while(var2.hasNext()) {
            ThiModule2.model.BenhAnVip benhAnVip = (ThiModule2.model.BenhAnVip) var2.next();
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
        ThiModule2.model.BenhAnVip benhAnVip=new ThiModule2.model.BenhAnVip(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,loaiVip,thoiHanVip);
        benhAnVipList.add(benhAnVip);
        ThiModule2.until.ReadAndWrite.writeVip(benhAnVipList);
        this.displayVip();
    }

    public static List<ThiModule2.model.BenhAnThuong> xoaThuong() throws IOException {
        List<ThiModule2.model.BenhAnThuong> benhAnThuongList = ThiModule2.until.ReadAndWrite.ReadThuong();
        System.out.println("Nhập mã bệnh án cần xóa");
        int maBenhAn = Integer.parseInt(scanner.nextLine());
//        String ma=scanner.nextLine();
        for(int i = 0; i <benhAnThuongList.size(); ++i) {
            if (maBenhAn==((BenhAnThuong)benhAnThuongList.get(i)).getMaBenhAn()) {
                benhAnThuongList.remove(benhAnThuongList.get(i));
                System.out.println("xóa thành công");
                ThiModule2.until.ReadAndWrite.writeThuong(benhAnThuongList);
            }
        }

        return benhAnThuongList;
    }

    public static List<ThiModule2.model.BenhAnVip> xoaVip() throws IOException {
        List<ThiModule2.model.BenhAnVip> benhAnVipList = ThiModule2.until.ReadAndWrite.ReadVip();
        System.out.println("Nhập mã bệnh án cần xóa");
        int maBenhAn = Integer.parseInt(scanner.nextLine());
//        String ma=scanner.nextLine();
        for(int i = 0; i < benhAnVipList.size(); ++i) {
            if (maBenhAn == ((ThiModule2.model.BenhAnVip)benhAnVipList.get(i)).getMaBenhAn()) {
                benhAnVipList.remove(benhAnVipList.get(i));
                System.out.println("xóa thành công");
                ThiModule2.until.ReadAndWrite.writeVip(benhAnVipList);
            }
        }

        return benhAnVipList;
    }

    public List<ThiModule2.model.BenhAnThuong> timKiemThuong() throws IOException {
        List<ThiModule2.model.BenhAnThuong> benhAnThuongList = ThiModule2.until.ReadAndWrite.ReadThuong();
        System.out.println("Nhập tên bệnh nhân cần tìm");
        String name = scanner.nextLine();

        for(int i = 0; i < benhAnThuongList.size(); ++i) {
            if (((BenhAnThuong)benhAnThuongList.get(i)).getTenBenhNhan().contains(name)) {
                System.out.println(benhAnThuongList.get(i));
            }
        }

        return null;
    }

    public List<ThiModule2.model.BenhAnVip> timKiemVip() throws IOException {
        List<ThiModule2.model.BenhAnVip> benhAnVipList = ReadAndWrite.ReadVip();
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

package ThiModule2.until;

import ThiModule2.model.BenhAnThuong;
import ThiModule2.model.BenhAnVip;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndWrite {
    static final String BENH_AN_THUONG = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\ThiModule2\\data\\benhanthuong.csv";
    static final String BENH_AN_VIP = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\ThiModule2\\data\\benhanvip.csv";

    public ReadAndWrite() {
    }

    public static List<ThiModule2.model.BenhAnThuong> ReadThuong() throws IOException {
        List<ThiModule2.model.BenhAnThuong> benhAnThuongList = new ArrayList();
        FileReader fileReader = new FileReader(BENH_AN_THUONG);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            if(temp.length == 8) {
                int soThuTu = Integer.parseInt(temp[0].trim());
                int maBenhAn = Integer.parseInt(temp[1].trim());
                String maBenhNhan = temp[2].trim();
                String tenBenhNhan = temp[3].trim();
                String ngayNhapVien = temp[4].trim();
                String ngayRaVien = temp[5].trim();
                String lyDoNhapVien = temp[6].trim();
                double phiNamVien=Double.parseDouble(temp[7].trim());
                ThiModule2.model.BenhAnThuong benhAnThuong=new ThiModule2.model.BenhAnThuong(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,phiNamVien);
                benhAnThuongList.add(benhAnThuong);
            } else {
                System.out.println("Danh sách trống");
            }

        }

        bufferedReader.close();
        return benhAnThuongList;
    }

    public static List<ThiModule2.model.BenhAnVip> ReadVip() throws IOException {
        List<ThiModule2.model.BenhAnVip> benhAnVipList = new ArrayList();
        FileReader fileReader = new FileReader(BENH_AN_VIP);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            if(temp.length == 9) {
                int soThuTu = Integer.parseInt(temp[0].trim());
                int maBenhAn = Integer.parseInt(temp[1].trim());
                String maBenhNhan = temp[2].trim();
                String tenBenhNhan = temp[3].trim();
                String ngayNhapVien = temp[4].trim();
                String ngayRaVien = temp[5].trim();
                String lyDoNhapVien = temp[6].trim();
                String loaiVip = temp[7].trim();
                String thoiHanVip = temp[8].trim();
                ThiModule2.model.BenhAnVip benhAnVip=new ThiModule2.model.BenhAnVip(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,loaiVip,thoiHanVip);
                benhAnVipList.add(benhAnVip);
            } else {
                System.out.println("Danh sách trống");
            }

        }

        bufferedReader.close();
        return benhAnVipList;
    }

    public static void writeThuong(List<ThiModule2.model.BenhAnThuong> benhAnThuongList) throws IOException {
        FileWriter fileWriter = new FileWriter(BENH_AN_THUONG, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = benhAnThuongList.iterator();

        while(var3.hasNext()) {
            ThiModule2.model.BenhAnThuong benhAnThuong = (BenhAnThuong) var3.next();
            bufferedWriter.write(benhAnThuong.getSoThuTu() + "," + benhAnThuong.getMaBenhAn() + "," + benhAnThuong.getMaBenhNhan() + "," + benhAnThuong.getTenBenhNhan() + "," + benhAnThuong.getNgayNhapVien() + "," +benhAnThuong.getNgayRaVien() + "," + benhAnThuong.getLyDoNhapVien()+","+benhAnThuong.getPhiNamVien() + "\n");
        }

        bufferedWriter.close();
    }

    public static void writeVip(List<ThiModule2.model.BenhAnVip> benhAnVipList) throws IOException {
        FileWriter fileWriter = new FileWriter(BENH_AN_VIP, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = benhAnVipList.iterator();

        while(var3.hasNext()) {
            ThiModule2.model.BenhAnVip benhAnVip = (BenhAnVip) var3.next();
            bufferedWriter.write(benhAnVip.getSoThuTu() + "," + benhAnVip.getMaBenhAn() + "," + benhAnVip.getMaBenhNhan() + "," + benhAnVip.getTenBenhNhan() + "," + benhAnVip.getNgayNhapVien() + "," +benhAnVip.getNgayRaVien() + "," + benhAnVip.getLyDoNhapVien()+","+benhAnVip.getLoaiVip()+","+benhAnVip.getThoiHanVip()+ "\n");
        }

        bufferedWriter.close();
    }
}

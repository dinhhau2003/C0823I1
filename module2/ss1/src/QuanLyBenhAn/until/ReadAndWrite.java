package QuanLyBenhAn.until;

import QuanLyBenhAn.model.BenhAnThuong;
import QuanLyBenhAn.model.BenhAnVip;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndWrite {
    static final String BENH_AN_THUONG = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\QuanLyBenhAn\\data\\benhanthuong.csv";
//    static final String BENH_AN_VIP = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\QuanLyBenhAn\\data\\benhanvip.csv";

    public ReadAndWrite() {
    }

    public static List<BenhAnThuong> ReadThuong() throws IOException {
        List<BenhAnThuong> benhAnThuongList = new ArrayList();
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
                BenhAnThuong benhAnThuong=new BenhAnThuong(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,phiNamVien);
                benhAnThuongList.add(benhAnThuong);
            } else {
                System.out.println("");
            }

        }

        bufferedReader.close();
        return benhAnThuongList;
    }

    public static List<BenhAnVip> ReadVip() throws IOException {
        List<BenhAnVip> benhAnVipList = new ArrayList();
        FileReader fileReader = new FileReader(BENH_AN_THUONG);
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
                BenhAnVip benhAnVip=new BenhAnVip(soThuTu,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,loaiVip,thoiHanVip);
                benhAnVipList.add(benhAnVip);
            } else {
                System.out.println("");
            }

        }

        bufferedReader.close();
        return benhAnVipList;
    }

    public static void writeThuong(List<BenhAnThuong> benhAnThuongList) throws IOException {
        FileWriter fileWriter = new FileWriter(BENH_AN_THUONG, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = benhAnThuongList.iterator();

        while(var3.hasNext()) {
            BenhAnThuong benhAnThuong = (BenhAnThuong) var3.next();
            bufferedWriter.write(benhAnThuong.getSoThuTu() + "," + benhAnThuong.getMaBenhAn() + "," + benhAnThuong.getMaBenhNhan() + "," + benhAnThuong.getTenBenhNhan() + "," + benhAnThuong.getNgayNhapVien() + "," +benhAnThuong.getNgayRaVien() + "," + benhAnThuong.getLyDoNhapVien()+","+benhAnThuong.getPhiNamVien() + "\n");
        }

        bufferedWriter.close();
    }

    public static void writeVip(List<BenhAnVip> benhAnVipList) throws IOException {
        FileWriter fileWriter = new FileWriter(BENH_AN_THUONG, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = benhAnVipList.iterator();

        while(var3.hasNext()) {
            BenhAnVip benhAnVip = (BenhAnVip) var3.next();
            bufferedWriter.write(benhAnVip.getSoThuTu() + "," + benhAnVip.getMaBenhAn() + "," + benhAnVip.getMaBenhNhan() + "," + benhAnVip.getTenBenhNhan() + "," + benhAnVip.getNgayNhapVien() + "," +benhAnVip.getNgayRaVien() + "," + benhAnVip.getLyDoNhapVien()+","+benhAnVip.getLoaiVip()+","+benhAnVip.getThoiHanVip()+ "\n");
        }

        bufferedWriter.close();
    }
}

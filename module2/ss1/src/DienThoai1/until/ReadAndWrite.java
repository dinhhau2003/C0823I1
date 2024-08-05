package DienThoai1.until;
import DienThoai1.model.DienThoaiChinhHang;
import DienThoai1.model.DienThoaiXachTay;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndWrite {
    static final String CHINH_HANG = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\DienThoai1\\data\\dienthoaichinhhang.csv";
    static final String XACH_TAY = "E:\\Codegym\\C0823I1\\module2\\ss1\\src\\DienThoai1\\data\\dienthoaixachtay.csv";

    public ReadAndWrite() {
    }

    public static List<DienThoaiChinhHang> ReadChinhHang() throws IOException {
        List<DienThoaiChinhHang> chinhHangList = new ArrayList();
        FileReader fileReader = new FileReader(CHINH_HANG);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            if(temp.length == 7) {
                int id = Integer.parseInt(temp[0].trim());
                String tenDienThoai = temp[1].trim();
                int gia = Integer.parseInt(temp[2].trim());
                int soLuong = Integer.parseInt(temp[3].trim());
                String nhaSanXuat = temp[4].trim();
                int thoiGianBaoHanh = Integer.parseInt(temp[5].trim());
                String phamViBaoHanh= temp[6].trim();
                DienThoaiChinhHang dienThoaiChinhHang=new DienThoaiChinhHang(id,tenDienThoai,gia,soLuong,nhaSanXuat,thoiGianBaoHanh,phamViBaoHanh);
                chinhHangList.add(dienThoaiChinhHang);
            } else {
                System.out.println("Danh sách trống");
            }

        }

        bufferedReader.close();
        return chinhHangList;
    }

    public static List<DienThoaiXachTay> ReadXachTay() throws IOException {
        List<DienThoaiXachTay> xachTayList = new ArrayList();
        FileReader fileReader = new FileReader(XACH_TAY);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            if(temp.length == 7) {
                int id = Integer.parseInt(temp[0].trim());
                String tenDienThoai = temp[1].trim();
                int gia = Integer.parseInt(temp[2].trim());
                int soLuong = Integer.parseInt(temp[3].trim());
                String nhaSanXuat = temp[4].trim();
                String quocGia = temp[5].trim();
                String trangThai = temp[6].trim();
                DienThoaiXachTay dienThoaiXachTay=new DienThoaiXachTay(id,tenDienThoai,gia,soLuong,nhaSanXuat,quocGia,trangThai);
                xachTayList.add(dienThoaiXachTay);
            } else {
                System.out.println("Danh sách trống");
            }

        }

        bufferedReader.close();
        return xachTayList;
    }

    public static void writeChinhHang(List<DienThoaiChinhHang> dienThoaiChinhHangList) throws IOException {
        FileWriter fileWriter = new FileWriter(CHINH_HANG, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = dienThoaiChinhHangList.iterator();

        while(var3.hasNext()) {
            DienThoaiChinhHang dienThoaiChinhHang = (DienThoaiChinhHang) var3.next();
            bufferedWriter.write(dienThoaiChinhHang.getId() + "," + dienThoaiChinhHang.getTenDienThoai() + "," + dienThoaiChinhHang.getGia() + "," + dienThoaiChinhHang.getSoLuong() + "," + dienThoaiChinhHang.getNhaSanXuat() + "," +dienThoaiChinhHang.getThoiGianBaoHanh() + "," + dienThoaiChinhHang.getPhamViBaoHanh() + "\n");
        }

        bufferedWriter.close();
    }

    public static void writeXachTay(List<DienThoaiXachTay> dienThoaiXachTayList) throws IOException {
        FileWriter fileWriter = new FileWriter(XACH_TAY, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Iterator var3 = dienThoaiXachTayList.iterator();

        while(var3.hasNext()) {
            DienThoaiXachTay dienThoaiXachTay = (DienThoaiXachTay) var3.next();
            bufferedWriter.write(dienThoaiXachTay.getId() + "," + dienThoaiXachTay.getTenDienThoai() + "," + dienThoaiXachTay.getGia() + "," + dienThoaiXachTay.getSoLuong() + "," + dienThoaiXachTay.getNhaSanXuat() + "," +dienThoaiXachTay.getQuocGia() + "," + dienThoaiXachTay.getTrangThai()+ "\n");
        }

        bufferedWriter.close();
    }
}

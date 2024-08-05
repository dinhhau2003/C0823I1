package ThiModule2.model;

public class BenhAnThuong extends BenhAn{
    private double phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(int soThuTu, int maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnThuong: " +super.toString()+
                "phiNamVien=" + phiNamVien;
    }

    @Override
    public String getToCSV() {
        return this.soThuTu+","+this.maBenhAn+","+this.maBenhNhan+","+this.tenBenhNhan+","+this.ngayNhapVien+","+this.ngayRaVien+","+this.lyDoNhapVien+","+this.phiNamVien;
    }
}

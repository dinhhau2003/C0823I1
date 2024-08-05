package TaiKhoan.model;

public class TaiKhoanTietKiem extends TaiKhoanNganHang{
    private double tienGoi;
    private String ngayGoi;
    private String laiSuat;
    private int kiHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(double tienGoi, String ngayGoi, String laiSuat, int kiHan) {
        this.tienGoi = tienGoi;
        this.ngayGoi = ngayGoi;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public TaiKhoanTietKiem(int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan, double tienGoi, String ngayGoi, String laiSuat, int kiHan) {
        super(id, maTaiKhoan, tenchuTaiKhoan, ngaytaoTaiKhoan);
        this.tienGoi = tienGoi;
        this.ngayGoi = ngayGoi;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public double getTienGoi() {
        return tienGoi;
    }

    public void setTienGoi(double tienGoi) {
        this.tienGoi = tienGoi;
    }

    public String getNgayGoi() {
        return ngayGoi;
    }

    public void setNgayGoi(String ngayGoi) {
        this.ngayGoi = ngayGoi;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKiHan() {
        return kiHan;
    }

    public void setKiHan(int kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tienGoi=" + tienGoi +
                ", ngayGoi='" + ngayGoi + '\'' +
                ", laiSuat='" + laiSuat + '\'' +
                ", kiHan=" + kiHan +
                '}';
    }
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.tienGoi + "," + this.ngayGoi + "," + this.laiSuat + "," + this.kiHan;
    }
}

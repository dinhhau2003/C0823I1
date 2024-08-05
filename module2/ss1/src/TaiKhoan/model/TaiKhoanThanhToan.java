package TaiKhoan.model;

public class TaiKhoanThanhToan extends TaiKhoanNganHang{
    private String soThe;
    private double soTienTrongTaiKhoan;

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(String soThe, double soTienTrongTaiKhoan) {
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TaiKhoanThanhToan(int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan, String soThe, double soTienTrongTaiKhoan) {
        super(id, maTaiKhoan, tenchuTaiKhoan, ngaytaoTaiKhoan);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public double getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(double soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return super.toString()+
                "soThe='" + soThe + '\'' +
                ", soTienTrongTaiKhoan=" + soTienTrongTaiKhoan +
                '}';
    }
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.soThe + "," + this.soTienTrongTaiKhoan;
    }
}

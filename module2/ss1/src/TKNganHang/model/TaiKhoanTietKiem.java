package TKNganHang.model;

public class TaiKhoanTietKiem extends TaiKhoanNganHang{
    private double tienGui;
    private String ngayGui;
    private String laiSuat;
    private int kiHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(int id, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan ,double tienGui, String ngayGui, String laiSuat, int kiHan) {
        super(id,maTaiKhoan,tenChuTaiKhoan,ngayTaoTaiKhoan);
        this.tienGui = tienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public double getTienGui() {
        return tienGui;
    }

    public void setTienGui(double tienGui) {
        this.tienGui = tienGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
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
                "tienGui=" + tienGui +
                ", ngayGui='" + ngayGui + '\'' +
                ", laiSuat='" + laiSuat + '\'' +
                ", kiHan=" + kiHan ;
    }

    @Override
    public String   getToCv() {
        return this.getId()+","+this.getMaTaiKhoan()+","+this.getTenChuTaiKhoan()+","+this.getNgayTaoTaiKhoan()+","+this.tienGui+","+this.ngayGui+","+this.laiSuat+","+this.kiHan;
    }
}


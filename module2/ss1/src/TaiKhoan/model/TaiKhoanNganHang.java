package TaiKhoan.model;

public abstract class TaiKhoanNganHang {
    private int id;
    private String maTaiKhoan;
    private String tenchuTaiKhoan;
    private String ngaytaoTaiKhoan;

    public TaiKhoanNganHang() {
    }

    public TaiKhoanNganHang(int id, String maTaiKhoan, String tenchuTaiKhoan, String ngaytaoTaiKhoan) {
        this.id = id;
        this.maTaiKhoan = maTaiKhoan;
        this.tenchuTaiKhoan = tenchuTaiKhoan;
        this.ngaytaoTaiKhoan = ngaytaoTaiKhoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenchuTaiKhoan() {
        return tenchuTaiKhoan;
    }

    public void setTenchuTaiKhoan(String tenchuTaiKhoan) {
        this.tenchuTaiKhoan = tenchuTaiKhoan;
    }

    public String getNgaytaoTaiKhoan() {
        return ngaytaoTaiKhoan;
    }

    public void setNgaytaoTaiKhoan(String ngaytaoTaiKhoan) {
        this.ngaytaoTaiKhoan = ngaytaoTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoanNganHang{" +
                "id=" + id +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenchuTaiKhoan='" + tenchuTaiKhoan + '\'' +
                ", ngaytaoTaiKhoan='" + ngaytaoTaiKhoan + '\'' +
                '}';
    }
    public String getInfoToCSV() {
        return this.id + "," + this.maTaiKhoan + "," + this.tenchuTaiKhoan + "," + this.ngaytaoTaiKhoan;
    }
}

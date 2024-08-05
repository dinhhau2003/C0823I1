package DienThoai1.model;

public class DienThoaiXachTay extends DienThoai{
    public String quocGia;
    public String trangThai;

    public DienThoaiXachTay() {

    }

    public DienThoaiXachTay(int id, String tenDienThoai, int gia, int soLuong, String nhaSanXuat, String quocGia, String trangThai) {
        super(id, tenDienThoai, gia, soLuong, nhaSanXuat);
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return super.toString() +
                "quocGia='" + quocGia + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }


    public String getToCv() {
        return this.id + "," + this.tenDienThoai + "," + this.gia + "," + this.soLuong + "," + this.nhaSanXuat + "," + this.quocGia + "," + this.trangThai;
    }
}

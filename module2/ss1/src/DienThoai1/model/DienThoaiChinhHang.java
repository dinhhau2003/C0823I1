package DienThoai1.model;

public class DienThoaiChinhHang extends DienThoai{
    public int thoiGianBaoHanh;
    public String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }




    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public DienThoaiChinhHang(int thoiGianBaoHanh, String phamViBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public DienThoaiChinhHang(int id, String tenDienThoai, int gia, int soLuong, String nhaSanXuat, int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, gia, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }


    @Override
    public String toString() {
        return "Điện thoại chính hãng: "+ super.toString()+
                "thoiGianBaoHanh=" + thoiGianBaoHanh +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'' +
                '}';
    }
    @Override
    public String getToCv() {
        return this.id + "," + this.tenDienThoai + "," + this.gia + "," + this.soLuong + "," + this.nhaSanXuat + "," + this.thoiGianBaoHanh + "," + this.phamViBaoHanh;
    }
}

package XuatNhapKhau.model;

public class ProductNhapKhau extends Product{
    private double priceNK;
    private String province;
    private double thueNK;
    public ProductNhapKhau() {
    }

    public ProductNhapKhau(double priceNK, String province, double thueNK) {
        this.priceNK = priceNK;
        this.province = province;
        this.thueNK = thueNK;
    }

    public ProductNhapKhau(int id, String maProduct, String nameProduct, double price, int quantity, String nhaSanXuat, String tacgia, double priceNK, String province, double thueNK) {
        super(id, maProduct, nameProduct, price, quantity, nhaSanXuat, tacgia);
        this.priceNK = priceNK;
        this.province = province;
        this.thueNK = thueNK;
    }

    public double getPriceNK() {
        return priceNK;
    }

    public void setPriceNK(double priceNK) {
        this.priceNK = priceNK;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getThueNK() {
        return thueNK;
    }

    public void setThueNK(double thueNK) {
        this.thueNK = thueNK;
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.priceNK + "," + this.province + "," + this.thueNK;
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.priceNK + "," + this.province + "," + this.thueNK;
    }
}

package XuatNhapKhau1.model;

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
        return this.priceNK;
    }

    public void setPriceNK(double priceNK) {
        this.priceNK = priceNK;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getThueNK() {
        return this.thueNK;
    }

    public void setThueNK(double thueNK) {
        this.thueNK = thueNK;
    }

    public String toString() {
        return super.toString() + "," + this.priceNK + "," + this.province + "," + this.thueNK;
    }
    @Override
    public String getToCv() {
        return this.getId()+","+this.getMaProduct()+","+this.getNameProduct()+","+this.getPrice()+","+this.getQuantity()+","+this.getNhaSanXuat()+","+this.getTacgia()+this.priceNK+","+this.province+","+this.thueNK;
    }
}

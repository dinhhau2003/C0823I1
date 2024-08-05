package XuatNhapKhau1.model;

public class ProductXuatKhau extends Product{
    private double priceXK;
    private String national;

    public ProductXuatKhau() {
    }

    public ProductXuatKhau(double priceXK, String national) {
        this.priceXK = priceXK;
        this.national = national;
    }

    public ProductXuatKhau(int id, String maProduct, String nameProduct, double price, int quantity, String nhaSanXuat, String tacgia, double priceXK, String national) {
        super(id, maProduct, nameProduct, price, quantity, nhaSanXuat, tacgia);
        this.priceXK = priceXK;
        this.national = national;
    }

    public double getPriceXK() {
        return this.priceXK;
    }

    public void setPriceXK(double priceXK) {
        this.priceXK = priceXK;
    }

    public String getNational() {
        return this.national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String toString() {
        return super.toString() + "," + this.priceXK + "," + this.national;
    }
    @Override
    public String getToCv() {
        return this.getId()+","+this.getMaProduct()+","+this.getNameProduct()+","+this.getPrice()+","+this.getQuantity()+","+this.getNhaSanXuat()+","+this.getTacgia()+this.priceXK+","+this.national;
    }
}

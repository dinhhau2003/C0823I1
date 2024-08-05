package XuatNhapKhau.model;

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
        return priceXK;
    }

    public void setPriceXK(double priceXK) {
        this.priceXK = priceXK;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.priceXK + "," + this.national;
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.priceXK + "," + this.national;
    }

}

package BaiTapLamThem.model;

public class Truck extends Vehicle{
    private double trongtai;

    public Truck() {
    }

    public Truck(double trongtai) {
        this.trongtai = trongtai;
    }

    public Truck(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, double trongtai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongtai = trongtai;
    }

    public double getTrongtai() {
        return trongtai;
    }

    public void setTrongtai(double trongtai) {
        this.trongtai = trongtai;
    }

    @Override
    public String toString() {
        return super.toString()+" , "+this.trongtai;
    }
    public String getInfoToCSV(){
        return super.getInfoToCSV()+","+this.trongtai;
    }
}

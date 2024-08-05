package BaiTapLamThem.model;

public class Car extends Vehicle{
    private int soChoNgoi;
    private String typeCar;

    public Car() {
    }

    public Car(int soChoNgoi, String typeCar) {
        this.soChoNgoi = soChoNgoi;
        this.typeCar = typeCar;
    }

    public Car(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String typeCar) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.typeCar = typeCar;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return super.toString()+" , "+this.soChoNgoi+" , "+this.typeCar;
    }
    public String getInfoToCSV(){
        return super.getInfoToCSV()+","+this.soChoNgoi+","+this.typeCar;
    }
}

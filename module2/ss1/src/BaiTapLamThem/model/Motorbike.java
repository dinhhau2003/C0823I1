package BaiTapLamThem.model;

public class Motorbike extends Vehicle{
    private double congsuat;

    public Motorbike() {
    }

    public Motorbike(double congsuat) {
        this.congsuat = congsuat;
    }

    public Motorbike(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, double congsuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.congsuat = congsuat;
    }

    public double getCongsuat() {
        return congsuat;
    }

    public void setCongsuat(double congsuat) {
        this.congsuat = congsuat;
    }

    @Override
    public String toString() {
        return super.toString()+" , "+this.congsuat;
    }
    public String getInfoToCSV(){
        return super.getInfoToCSV()+","+this.congsuat;
    }
}

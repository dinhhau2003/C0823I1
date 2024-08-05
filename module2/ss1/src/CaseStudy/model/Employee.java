package CaseStudy.model;

import java.util.Locale;

public class Employee extends Person{
    private String trinhDo;
    private String viTri;
    private double luong;

    public Employee() {
    }

    public Employee(String id, String name, Locale age, String sex, String address, String idCard, String email, String trinhDo, String viTri, double luong) {
        super(id, name, age, sex, address, idCard, email);
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "Employee= " +super.toString()+
                ", trinhDo='" + trinhDo + '\'' +
                ", viTri='" + viTri + '\'' +
                ", luong=" + luong +
                '}';
    }
}

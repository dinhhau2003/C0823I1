package ss4;

import java.util.Scanner;

public class LopHCN {
    double width,height;
    public LopHCN(){
    }
    public LopHCN(double width,double height){
        this.width=width;
        this.height=height;
    }
    public double getArea(){
        return this.height*this.width;
    }
    public double getPerimeter(){
        return (this.width+this.height)*2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "LopHCN{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập chiều dài: ");
        double width=Double.parseDouble(sc.nextLine());
        System.out.println("Nhập chiều rộng: ");
        double height=Double.parseDouble(sc.nextLine());
        LopHCN lopHCN=new LopHCN(width,height);
        System.out.println(lopHCN.toString());
        System.out.println("chu vi hcn là: "+lopHCN.getPerimeter());
        System.out.println("diện tích hcn là: "+lopHCN.getArea());

    }
}

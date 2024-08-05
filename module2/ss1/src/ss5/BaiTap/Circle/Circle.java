package ss5.BaiTap.Circle;

import java.util.Scanner;

public class Circle {
   double radius=1.0;
    private  String color="red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*Math.pow(this.radius,2);
    }

    @Override
    public String toString() {
        return "dien tich hinh tron co ban kinh"+this.getRadius()+"la "+this.getArea();
    }

    public static void main(String[] args) {

    }
}
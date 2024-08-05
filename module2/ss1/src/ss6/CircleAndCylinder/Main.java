package ss6.CircleAndCylinder;

import ss6.CircleAndCylinder.Circle;
import ss6.CircleAndCylinder.Cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle);
        System.out.println(circle.getArea());
        circle=new Circle(2.0,"blue");
        System.out.println(circle);
        System.out.println(circle.getArea());

        Cylinder cylinder=new Cylinder();
        System.out.println(cylinder);
        System.out.println(cylinder.geVolume());
        cylinder=new Cylinder(3.0,"black",1.0);
        System.out.println(cylinder);
        System.out.println(cylinder.geVolume());
    }

}

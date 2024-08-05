package ss5.BaiTap.Circle;

public class Main {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle.radius);
        Circle circle1=new Circle(4);
        Circle circle2=new Circle(10);
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
    }
}

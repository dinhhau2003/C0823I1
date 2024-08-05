package ss7.Bt1;

public class TestResizeable {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println("Diện tích trước : " + circle.getArea());
        circle.resize(10);
        System.out.println(circle);
        System.out.println("Diện tích sau resize : " + circle.getArea());
        Retangle retangle = new Retangle(2.5, 3.8);
        System.out.println(retangle);
        System.out.println("Diện tích trước : " + retangle.getArea());
        retangle.resize(150);
        System.out.println(retangle);
        System.out.println("Diện tích sau : " + retangle.getArea());
        Square square=new Square(5.0);
        System.out.println(square);
        System.out.println("Diện tích trước: "+square.getArea());
        square.resize(100);
        System.out.println(square);
        System.out.println("diện tích sau : "+square.getArea());
    }
}

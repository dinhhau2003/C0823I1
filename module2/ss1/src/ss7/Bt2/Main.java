package ss7.Bt2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(4.0);
        shapes[1]=new Rectangle(2.0,5.0);
        shapes[2]=new Square(6.0);
        for (Shape shape:shapes){
            System.out.println(shape.getArea());

        if (shape instanceof Colorable) {
            Colorable colorableShape = (Colorable) shape;
            colorableShape.howToColor();
        }
    }
    }
}

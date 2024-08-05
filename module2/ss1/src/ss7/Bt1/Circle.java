package ss7.Bt1;

public class Circle extends Shape implements Resizeable{
    private double radius=1.0;

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "A circle with radius= " +
                 getRadius() +
                ", which is a subclass of "+super.toString();
    }
    public void resize(double percent){
        radius *= (1 + percent/100);
    }
}

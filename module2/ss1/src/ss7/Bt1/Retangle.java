package ss7.Bt1;

public class Retangle extends Shape implements Resizeable {
    private double width=1.0;
    private double length=1.0;

    public Retangle() {
    }

    public Retangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Retangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea(){
        return width*this.length;
    }
    public double getPerimeter(){
        return 2*(width+this.length);
    }

    @Override
    public String toString() {
        return " A Retangle width width= " + getWidth() +
                ", and length=" + getLength() +
                ", which is a subclass of "+super.toString();
    }

    @Override
    public void resize(double percent) {
        this.length *= (1 + percent / 100.0);
        this.width *= (1 + percent / 100.0);
    }
}

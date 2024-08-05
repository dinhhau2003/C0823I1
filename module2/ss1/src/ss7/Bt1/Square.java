package ss7.Bt1;

public class Square extends Shape implements Resizeable {
    @Override
    public void resize(double percent) {
        this.side *= (1 + percent / 100.0);
    }
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public Square() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return side * side;
    }
    @Override
    public String toString() {
        return "A square with side= " +
                 getSide() +", which is a subclass of "+super.toString();
    }

}

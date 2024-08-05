package ss6.PointAndMoveablePoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint p1=new MovablePoint();
        MovablePoint p2=new MovablePoint(2,3,4,5);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p2.move());
        System.out.println(p2);
    }
}

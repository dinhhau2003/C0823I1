package ss10.ThucHanh.List;

public class Main {
    public static void main(String[] args) {
        MyList<Integer>listInteger=new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        System.out.println("elements 4: "+listInteger.get(4));
        System.out.println("elements 2: "+listInteger.get(2));
        System.out.println("elements 1: "+listInteger.get(1));
        listInteger.get(6);
        System.out.println(listInteger.get(6));
    }
}

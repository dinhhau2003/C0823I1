package ss10.BaiTap.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer>myList=new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        System.out.println("elements 1: "+myList.get(1));
        System.out.println("elements 2: "+myList.get(2));
        System.out.println("elements 3: "+myList.get(3));

    }
}

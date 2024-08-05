package ss7.Bt1;

public class RetangleTest {
    public static void main(String[] args) {
        Retangle retangle=new Retangle();
        System.out.println(retangle);

        retangle=new Retangle(2.3,5.8);
        System.out.println(retangle);

        retangle=new Retangle("orange",true,2.5,3.8);
        System.out.println(retangle);
    }
}

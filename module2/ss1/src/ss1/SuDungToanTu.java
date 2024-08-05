package ss1;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float width,height;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter width: ");
        width=Float.parseFloat(scanner.nextLine());
        System.out.println("Enter height: ");
        height=Float.parseFloat(scanner.nextLine());
        float area=width*height;
        System.out.println("Area is: "+area);
    }
}

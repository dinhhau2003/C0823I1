package ss1;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Ginven aquation as'a * X +b=c',please enter constants:");
        Scanner scanner=new Scanner(System.in);
        System.out.println("a: ");
        double a=Double.parseDouble(scanner.nextLine());
        System.out.println("b: ");
        double b=Double.parseDouble(scanner.nextLine());
        System.out.println("c: ");
        double c=Double.parseDouble(scanner.nextLine());
        if (a!=0){
            double answer=(c-b)/a;
            System.out.println("Equation pass with x=" + answer);
        }else {
            if (b==c){
                System.out.println("The solution is all x!");
            }else {
                System.out.println("No solution!");
            }
        }
    }

}

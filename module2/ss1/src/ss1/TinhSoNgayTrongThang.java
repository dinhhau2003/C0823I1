package ss1;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("which month that you to count days? ");
        int month=Integer.parseInt(scanner.nextLine());
        String daysInMonth;
        switch (month){
            case 2:
//                System.out.println("The month '2' has 28 or 29 days!");
                daysInMonth="28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 12:
//                System.out.println("the month "+month+"has 31 days!");
                daysInMonth="31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
//                System.out.println("the month "+month+"has 30 days!");
                daysInMonth="30";
                break;
            default:
//                System.out.println("Invalid input!");
                daysInMonth="";
                break;
        }
        if (!daysInMonth.equals("")) System.out.printf("The month '%d' has '%s' days!",month,daysInMonth);
        else System.out.println("Invalid input!");
    }
}

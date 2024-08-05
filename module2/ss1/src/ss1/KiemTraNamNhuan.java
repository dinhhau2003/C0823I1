package ss1;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào năm");
        int year=Integer.parseInt(scanner.nextLine());
        boolean isLeapYear=false;
        if (year%4==0){
            if (year%100==0){
                if (year%400==0){
                    isLeapYear=true;
                }
            }else {
                isLeapYear=true;
            }
        }
        if (isLeapYear){
            System.out.println("is a leap year: "+year);
        }else {
            System.out.println("is not a leap year: "+year);
        }
//        if(year % 4 == 0){
//            if(year % 100 == 0){
//                if(year % 400 == 0){
//                    System.out.printf("%d is a leap year", year);
//                } else {
//                    System.out.printf("%d is NOT a leap year", year);
//                }
//            } else {
//                System.out.printf("%d is a leap year", year);
//            }
//        } else {
//            System.out.printf("%d is NOT a leap year", year);
//        }
    }
}

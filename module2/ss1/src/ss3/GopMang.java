package ss3;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int n1,n2;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Nhập vào số lượng phần tử của mảng 1: ");
            n1=Integer.parseInt(sc.nextLine());
        }while (n1<=0);
        int []A=new int[n1];
        System.out.println("Nhập vào các phần tử của mảng: ");
        for (int i = 0; i < n1; i++) {
            System.out.println("Nhập phần tử thứ "+i+": ");
            A[i]=Integer.parseInt(sc.nextLine());
        }
        do {
            System.out.println("Nhập vào số lượng phần tử của mảng 2: ");
            n2=Integer.parseInt(sc.nextLine());
        }while (n2<=0);
        int []A1=new int[n2];
        System.out.println("Nhập vào các phần tử của mảng: ");
        for (int i = 0; i < n2; i++) {
            System.out.println("Nhập phần tử thứ "+i+": ");
            A1[i]=Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mảng 1 đã nhập là: ");
        for(int x:A){
            System.out.print(x+" ");
        }
        System.out.print("\n"+"Mảng 2 đã nhập là: ");
        for(int x:A1){
            System.out.print(x+" ");
        }
        int [] newArr=new int[A.length+A1.length];
        for (int i = 0; i < A.length; i++) {
            newArr[i]=A[i];
        }
        for (int i = 0; i < A1.length; i++) {
            newArr[A1.length+i]=A1[i];
        }
        System.out.println("\n"+"Mảng sau khi gộp là: ");
         for (int x:newArr){
             System.out.print(x+" ");
         }
    }
}

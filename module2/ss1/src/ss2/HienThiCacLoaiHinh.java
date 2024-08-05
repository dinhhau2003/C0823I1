package ss2;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
       int choice=-1;
        Scanner sc=new Scanner(System.in);
        while (choice!=0){
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Nhap chiều dài");
                    int m=sc.nextInt();
                    System.out.println("Nhap chiều rộng");
                    int n=sc.nextInt();
                    if(m>0&&n>0){
                        for(int i=1;i<=m;i++){
                            for(int j=1;j<=n;j++){
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                    } break;
                case 2:
                    System.out.println("nhập số dòng: ");
                    int h= sc.nextInt();
                    if (h>0){
                        for (int i=1;i<=h;i++){
                            for (int j=1;j<=i;j++){
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                    }break;
                case 3:
                    System.out.println("nhập số dòng");
                    int h2= sc.nextInt();
                    if (h2>0){
                        for (int i=h2;i>=1;i--){
                            for (int j=1;j<=i;j++){
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                    }break;
                case 4:
                    System.exit(0);
            }
        }
    }
}

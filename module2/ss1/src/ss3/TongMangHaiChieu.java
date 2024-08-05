package ss3;

import java.util.Scanner;

public class TongMangHaiChieu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào số hàng của mảng: ");
        int rowS=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột của mảng: ");
        int colS=Integer.parseInt(sc.nextLine());
        int [][]arr=new int[rowS][colS];
        System.out.println("Nhập vào các phẩn tử của mảng: ");
        for (int i = 0; i < rowS; i++) {
            for (int j = 0; j < colS; j++) {
                System.out.println("Nhập phần tử thứ "+i+" "+j+" :");
                arr[i][j]=Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println("Mảng vừa nhập là: ");
        for (int i = 0; i < rowS; i++) {
            for (int j = 0; j < colS; j++) {
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
        System.out.println("Nhập số thứ tự cột cần tính tổng: ");
        int col=Integer.parseInt(sc.nextLine());
        int sum=0;
        for(int i = 0; i < arr.length; i++){
                sum += arr[i][col];

        }
        System.out.println("tổng của cột " + col + " là " + sum);

    }
}

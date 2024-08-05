package ss3;

import java.util.Scanner;

public class TimMaxCuaMangHaiChieu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào số hàng của mảng 2 chiều: ");
        int row=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột của mảng 2 chiều: ");
        int col=Integer.parseInt(sc.nextLine());
        int [][] arr=new int[row][col];
        System.out.println("Nhập từng phần tử của mảng: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập phần tử thứ "+i+"và"+j+"của mảng: ");
                arr[i][j]=Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println("Mảng 2 chiều vừa nhập là: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int max=arr[0][0];
        int indexRow=0;
        int indexCol=0;
        for (int i=0;i<row;i++){
            for (int j = 0; j < col; j++) {
                if (arr[i][j]>max){
                    max=arr[i][j];
                    indexRow=i;
                    indexCol=j;
                }
            }
        }
        System.out.println("max của mảng 2 chiều là: "+max);
        System.out.println("vị trí của max vừa tìm được là: ["+indexRow+"] ["+indexCol+"]:");
    }
}

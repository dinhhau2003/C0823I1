package ss3;

import java.util.Scanner;

public class TongCacSoDuongCheoMaTran {
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
        int total = 0;
        for(int row = 0; row < arr.length; row++) {
            for(int column = 0; column < arr[row].length; column++) {
                if(row==column){
                    total += arr[row][column];
                }
            }
        }
        int total1 = 0;
        for(int row = 0; row < arr.length; row++) {
            for(int column = 0; column < arr[row].length; column++) {
                if(row+column==arr.length-1){
                    total1 += arr[row][column];
                }
            }
        }
        System.out.println("Tong cac phan tu tren duong cheo chinh cua matrix = " + total);
        System.out.println("Tong cac phan tu tren duong cheo chinh cua matrix = " + total1);
    }
}

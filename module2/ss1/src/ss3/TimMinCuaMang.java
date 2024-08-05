package ss3;

import java.util.Scanner;

public class TimMinCuaMang {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Nhập số lượng phần tử của mảng: ");
            n=Integer.parseInt(sc.nextLine());
        }while (n<=0);
        int [] arr=new int[n];
        System.out.println("Nhập phần tử vào mảng: ");
        for (int i=0;i<n;i++){
            System.out.println("Nhập phần tử thứ "+i+": ");
            arr[i]=Integer.parseInt(sc.nextLine());
        }
        System.out.println("mảng vừa nhập là: ");
        for (int x:arr){
            System.out.print(x+" ");
        }
        int min=arr[0];
        int index=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
                index=i;
            }
        }
        System.out.println("\n"+"Min của mảng là: "+min);
        System.out.println("vị trí của min là: "+index);
    }

}

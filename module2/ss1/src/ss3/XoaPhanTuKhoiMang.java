package ss3;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n ,i,c;
        do {
            System.out.println("Nhập vào số lượng phần tử của mảng: ");
            n=Integer.parseInt(sc.nextLine());
        }while (n<=0);
        int[] A =new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for ( i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ "+i+": ");
            A[i]=Integer.parseInt(sc.nextLine());
        }
        System.out.println("mảng vừa nhập là: ");
        for (i=0;i<n;i++){
            System.out.print(A[i]+ " ");
        }
        System.out.println("\n"+"Nhập phần tử cần xóa khỏi mảng: ");
        int k=Integer.parseInt(sc.nextLine());
//        for (c=i=0;i<n;i++){
//            if (A[i]!=k){
//                A[c]=A[i];
//                c++;
//            }
//        }
//        n=c;
        int index=-1;
        for ( i = 0; i < n; i++) {
            if (A[i]==k){
                index=i;
                break;
            }

        }
        if (index!=-1){
            for (i = index; i <n-1 ; i++) {
                A[i]=A[i+1];
            }
            n--;
        }
        System.out.println("Mảng còn lại sau khi xóa phần tử" +k+ "là: ");
        for ( i = 0; i < n; i++) {
            System.out.print(A[i]+" ");
        }
    }
}

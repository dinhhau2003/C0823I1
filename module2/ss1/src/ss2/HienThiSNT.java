package ss2;

import java.util.Scanner;

public class HienThiSNT {
    public static void main(String[] args) {
        int count=0,N=2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng nguyên tố muốn in ra");
        int number=Integer.parseInt(sc.nextLine());
        while (count<number){
            int count2=0;
            for (int i=2;i<=Math.sqrt(N);i++){
                if (N % i==0){
                    count2++;
                }
            }
            if (count2==0){
                System.out.println(N+"");
                count++;
            }
            N++;
        }
    }
}

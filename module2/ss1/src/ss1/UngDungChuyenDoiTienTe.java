package ss1;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double vnd=23000,usd,rate;
        System.out.println("Nhập vào usd: ");
        usd= scanner.nextDouble();
        rate=vnd*usd;
        System.out.println(usd+" USD = "+rate+" vnd");
    }
}

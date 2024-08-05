package ss3;

import java.util.Scanner;

public class DemSoLanXuatHienKyTu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi ký tự: ");
        String str=sc.nextLine();
        System.out.println("Nhập vào ký tự cần kiểm tra: ");
        char c=sc.next().charAt(0);
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==c){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của "+c+ " là "+count);
    }
}

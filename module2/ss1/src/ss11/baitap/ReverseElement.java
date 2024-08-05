package ss11.baitap;

import java.util.Scanner;
import java.util.Stack;

public class ReverseElement {
    public static void main(String[] args) {

                Scanner input = new Scanner(System.in);

                // Đảo ngược số
                Stack<Integer> stacknum = new Stack<>();
                System.out.println("Nhập số phần tử");
                int n = input.nextInt();
                input.nextLine(); // Xử lý dòng mới
                System.out.println("Nhập số");
                for (int i = 0; i < n; i++) {
                    Integer integer = input.nextInt();
                    stacknum.push(integer);
                }
                System.out.println("Số đảo ngược");
                while (!stacknum.isEmpty()) {
                    System.out.print(stacknum.pop());
                }

                // Đảo ngược chuỗi
                Stack<String> stackstring = new Stack<>();
                System.out.println("\nNhập vào chuỗi");
                String string = input.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    stackstring.push(String.valueOf(string.charAt(i)));
                }
                System.out.println("Chuỗi đảo ngược");
                for (int i = 0; i < string.length(); i++) {
                    System.out.print(stackstring.pop());
                }
            }
        }




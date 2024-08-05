package ss2;
import java.util.Scanner;
public class text {

    public static void main(String[] args) {
        System.out.print("Nhập vào kích thước của mảng : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size    ; i++) {
            System.out.print("Nhập số nguyên vào phần tử thứ " + i +" : ") ;
            arr[i] = scanner.nextInt();
        }
        System.out.print("Mảng đã nhập : ");

        for (int x:arr) {
            System.out.print(x + " ; ");
        }
        System.out.print("\nNhập vào phần tử cần chèn : ");
        int element = scanner.nextInt();
        System.out.print("\nNhập vào vị trí cần chèn : ");
        int index = scanner.nextInt();
        for (int i = size-1; i >index ; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        System.out.print("Mảng sau khi thêm  : ");

        for (int x:arr) {
            System.out.print(x + " ; ");
        }
    }
    }




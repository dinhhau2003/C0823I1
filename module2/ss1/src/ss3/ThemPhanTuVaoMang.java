package ss3;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n;

        do {
            System.out.println("Nhập số lượng phần tử của mảng: ");
            n = Integer.parseInt(sc.nextLine());
        } while (n <= 0);

        int[] A = new int[n];

        System.out.println("Nhập vào các phần tử của mảng: ");
        for (i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            A[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Mảng vừa nhập là: ");
        for (i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println("Nhập phần tử cần chèn vào mảng: ");
        int k = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập vào vị trí cần chèn phần tử: ");
        int index = Integer.parseInt(sc.nextLine());

        if (index < 0 || index >= A.length - 1) {
            System.out.println("Vị trí không hợp lệ.");
        } else {
            // Tạo mảng tạm thời lớn hơn mảng ban đầu
            int[] tempArray = new int[A.length + 1];

            // Sao chép phần tử từ mảng ban đầu sang mảng tạm thời
            for (i = 0; i <= index; i++) {
                tempArray[i] = A[i];
            }

            // Chèn phần tử mới vào mảng tạm thời
            tempArray[index] = k;

            // Sao chép phần tử còn lại từ mảng ban đầu sang mảng tạm thời
            for (i = index + 1; i < tempArray.length; i++) {
                tempArray[i] = A[i - 1];
            }

            // Hiển thị mảng sau khi chèn phần tử
            System.out.println("Mảng sau khi chèn phần tử " + k + " vào vị trí " + index + ":");
//                System.out.println(Arrays.toString(tempArray));
            for (int x:tempArray){
                System.out.print(x+" ");
            }
        }
    }
}

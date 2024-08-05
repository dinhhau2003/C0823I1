package XuatNhapKhau.until;

import java.util.Scanner;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);


    public static boolean confirm(String mess) {
        while (true) {
            System.out.println(mess);
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) {
                return true;
            } else if (option.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Bạn phải nhập Y hoặc N");
            }
        }
    }
}

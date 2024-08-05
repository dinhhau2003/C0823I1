package TKNganHang.until;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    public static final String REGEX_STR="^[A-Z][a-z]+$";
    static Scanner scanner = new Scanner(System.in);
    //3 tham sô người dùng nhập vào, regex , lỗi
    public static String regex(String temp, String regex, String error) {
        boolean check = true;
        do {
            //
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }

        } while (check);
        return temp;
    }
    public static boolean nameValidate(String regex) {
        return Pattern.matches(REGEX_STR, regex);
    }
}

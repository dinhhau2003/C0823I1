package TaiKhoan.until;

import java.util.Scanner;

public class CheckInputData {
    private static Scanner scanner = new Scanner(System.in);
    private static final String NGAYTAOTAIKHOAN_VALID = "^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[012])\\/\\d{4}$";
    private static final String MATKTHANHTOAN_VALID = "^(TKThanhToan)(-)\\d{5}$";
    private static final String MATKTIETKIEM_VALID = "^(TKTietKiem)(-)\\d{5}$";
    public static int CheckInputOption(String message, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                int option = Integer.parseInt(scanner.nextLine());
                if (option < min || option > max) {
                    System.out.printf("Option phải từ %d đến %d", min, max);
                    continue;
                }
                return option;
            } catch (Exception e) {
                System.out.println("Option phải là số.");
            }
        }
    }
    public static String checkInputNull(String message, String warn) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine();
            if(result.length() == 0 || result == null) {
                System.out.println(warn + "không được để trống.");
                continue;
            }
            return result;
        }
    }
    public static int checkInputInt(String message, int min, String warn) {
        while (true) {
            try {
                System.out.println(message);
                int id = Integer.parseInt(scanner.nextLine());
                if (id < min) {
                    System.out.printf(warn + "phải nằm số lớn hơn %d", min);
                    continue;
                }
                return id;
            } catch (Exception e) {
                System.out.println(warn + "phải là số.");
            }
        }
    }
    public static String checkInputDate(String message) {
        while (true) {
            System.out.println(message);
            String date= scanner.nextLine();
            if(date.matches(NGAYTAOTAIKHOAN_VALID)) {
                return date;
            } else {
                System.out.println("Ngày không hợp lệ.Vui lòng nhập lại.");
            }
        }
    }
    public static double checkInputDouble(String message, double min, String warn) {
        while (true) {
            try {
                System.out.println(message);
                double result = Double.parseDouble(scanner.nextLine());
                if (result < min ) {
                    System.out.printf(warn + "phải lớn hơn 0.");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println(warn + "phải là số.");
            }
        }
    }
    public static String checkInputmaTkThanhToan(String message) {
        while (true) {
            System.out.println(message);
            String result= scanner.nextLine();
            if(result.matches(MATKTHANHTOAN_VALID)) {
                return result;
            } else {
                System.out.println("Mã tài khoản thanh toán không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
    public static String checkInputmaTkTietKiem(String message) {
        while (true) {
            System.out.println(message);
            String result= scanner.nextLine();
            if(result.matches(MATKTIETKIEM_VALID)) {
                return result;
            } else {
                System.out.println("Mã tài khoản tiét kiệmT không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}

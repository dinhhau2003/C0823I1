package BaiTapLamThem.until;

import java.util.Scanner;

public class CheckInputData {
    private static Scanner scanner = new Scanner(System.in);
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

    public static String checkInput(String message, String rerex, String warn) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine();
            if(result.matches(rerex)) {
                return result;
            } else {
                System.out.println(warn);
            }
        }
    }

    public static int checkInputInt(String message, int min) {
        while (true) {
            try {
                System.out.println(message);
                int result = Integer.parseInt(scanner.nextLine());
                if(result < min) {
                    System.out.println("Năm sản xuất lớn hơn 0.Vui lòng nhập lại.");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("Năm sản xuất phải là số.");
            }


        }
    }

    public static double checkInputDouble(String message, double min, String warn) {
        while (true) {
            try {
                System.out.println(message);
                double result = Double.parseDouble(scanner.nextLine());
                if (result < min ) {
                    System.out.printf(warn + "phải lớn hơn %d", min);
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println(warn + "phải là số.");
            }
        }
    }

    public static String checkInputNull(String message, String warn) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine();
            if(result.length() == 0 || result == null) {
                System.out.println(warn + "không được để trống.");
            }
            return result;
        }
    }
    public static int checkInputSoChoNgoi(String message, int min) {
        while (true) {
            try {
                System.out.println(message);
                int soChoNgoi = Integer.parseInt(scanner.nextLine());
                if(soChoNgoi <= min) {
                    System.out.printf("Số chỗ ngồi phải lớn hơn %d", min);
                    continue;
                }
                return soChoNgoi;
            } catch (Exception e) {
                System.out.println("Số chỗ ngồi phải là số.");
            }
        }
    }
    public static String checkInputTypeCar(String message) {
        while (true) {
            System.out.println(message);
            String typeCar = scanner.nextLine();
            if(typeCar.equalsIgnoreCase("Du lich") || typeCar.equalsIgnoreCase("Xe khach")) {
                return typeCar;
            } else {
                System.out.println("Kiểu xe phải là loại xe du lịch hoặc xe khách.");
            }
        }
    }
}

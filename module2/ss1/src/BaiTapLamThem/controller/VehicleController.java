//package BaiTapLamThem.controller;
//
//import BaiTapLamThem.service.IVehicleService;
//import BaiTapLamThem.service.VehicleService;
//import ontap.until.CheckInputData;
//
//import java.util.Scanner;
//
//public class VehicleController {
//    private static IVehicleService vehicleService = new VehicleService();
//    public static void displayMenu() {
//        Scanner scanner = new Scanner(System.in);
//        boolean flag = true;
//        do {
//            System.out.println("1.Thêm mới phương tiện.");
//            System.out.println("2.Hiển thị phương tiện.");
//            System.out.println("3.Xóa phương tiện.");
//            System.out.println("4.Thoát.");
//            int choice = CheckInputData.CheckInputOption("Mời bạn nhập chức năng để lựa chọn:", 1, 4);
//            switch (choice) {
//                case 1: {
//                    vehicleService.addVehicle();
//                    break;
//                }
//                case 2: {
//                    vehicleService.displayVehicle();
//                    break;
//                }
//                case 3: {
//                    String bienKiemSoatdel = CheckInputData.checkInputNull("Nhập biển số xe cần xóa:", "Biển số xe");
//                    vehicleService.removeVehicle(bienKiemSoatdel);
//                    break;
//                }
//                default: {
//                    flag = false;
//                }
//
//            }
//        } while (flag);
//    }
//
//}

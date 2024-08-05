package MVC.view;

import MVC.controller.StudentController;
import MVC.model.Student;

import java.util.List;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

            StudentController studentController = new StudentController();
            boolean flag = true;
            do {
                System.out.println("Chọn chức năng\n" +
                        "1.Danh sách\n" +
                        "2.Thêm mới\n" +
                        "3.Xoá\n" +
                        "4.Tìm kiếm\n" +
                        "5.Thoát");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        System.out.println("Hiển thị danh sách");
                        List<Student>students=studentController.getAll();
                        displayStudent(students);
                        break;
                    case 2:
                        System.out.println("Thêm mới");
                        Student newStudent = inputDataStudent();
                        studentController.add(newStudent);
                        break;
                    case 3:
                        System.out.println("Chức năng xoá");
                        System.out.println("Nhập id cần xoá");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        String deleteMessage = studentController.delete(deleteId);
                        System.out.println(deleteMessage);
                        // code xoá
                        break;
                    case 4:
                        System.out.println("Chức năng tìm liếm");
                        // code chỉnh sửa
                        System.out.println("nhập tên cần tìm");
                        String searchName = scanner.nextLine();
                        List<Student> searchList = studentController.searchByName(searchName);
                        if (searchList.isEmpty()){
                            System.out.println("Không tìm thấy kết quả");
                        }
                        displayStudent(searchList);
                        break;
                    default:
                        flag =false;
                }
            }while (flag);

            System.out.println("Kết thúc chương trình ");
        }
        public static void displayStudent(List<Student> students){
            for (Student student: students) {
                if (student!=null){
                    System.out.println(student);
                }else {
                    break;
                }
            }
        }
        public static Student inputDataStudent(){
            System.out.println("nhập id");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("nhập tên");
            String name = scanner.nextLine();
            Student student = new Student(id,name);
            return  student;
        }
}

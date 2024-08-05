package DeMo;

import java.util.Scanner;

public class StudentManager {
    public static Student[] students=new Student[10];
    static Scanner scanner=new Scanner(System.in);
    static {
        students[0]=new Student(1,"hậu");
        students[1]=new Student(2,"huy");
        students[2]=new Student(3,"quang");
    }

    public static void main(String[] args) {
        StudentManager studentManager=new StudentManager();
        boolean flag=true;
        do {
            System.out.println("chọn chức năng:\n"+
                    "1.Danh sách\n"+
                    "2.thêm mới\n"+
                    "3.Xóa\n"+
                    "4.Chỉnh sửa\n"+
                    "5.Thoát\n");
            System.out.println("Nhập số để chọn chức năng trên menu");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("Hiển thị danh sách: ");
                    studentManager.showList();
                    break;
                case 2:
                    System.out.println("Thêm mới ");
                    studentManager.add();
                    break;
                case 3:
                    System.out.println("Xóa ");
                    break;
                case 4:
                    System.out.println("chỉnh sửa");
                    break;
                default:
                    flag=false;
            }
        }while (flag);
        System.out.println("kết thúc chương trình");
    }
    public void showList(){
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null){
                System.out.println(students[i]);
            }
        }
    }
    public void add(){
        System.out.println("nhập id: ");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên: ");
        String name=scanner.nextLine();
        Student newStudent=new Student(id,name);
        for (int i = 0; i < students.length; i++) {
                if (students[i]==null){
                    students[i]=newStudent;
                    break;
                }
        }
    }
}

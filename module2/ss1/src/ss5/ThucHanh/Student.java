package ss5.ThucHanh;

public class Student {

        private int rollno;
        private String name;
        private static String college="BBDIT";
        Student(int r,String n){
            rollno=r;
            name=n;
        }
        static void change(){
            college="CODE GYM";
        }
        void display(){
            System.out.println(rollno+" "+name+" "+college);
        }

        public static void main(String[] args) {
            ss5.ThucHanh.Student.change();
            ss5.ThucHanh.Student s1=new ss5.ThucHanh.Student(111,"Hoang");
            ss5.ThucHanh.Student s2=new ss5.ThucHanh.Student(222,"Hoa");
            ss5.ThucHanh.Student s3=new ss5.ThucHanh.Student(333,"Tham");
            s1.display();
            s2.display();
            s3.display();
        }
    }



package ss4;

import java.util.Scanner;

public class QuadraticEquation {
    private double a,b,c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public double getDiscriminant(){
        return b*b-(4*a*c);
    }
    public double getRoot1(){
        double delta=this.getDiscriminant();
        if (getDiscriminant()>=0){
            return (-b+Math.sqrt(getDiscriminant()))/(a*2);
        }else {
            return 0;
        }
    }
    public double getRoot2(){
        if (getDiscriminant()>=0){
            return (-b-Math.sqrt(getDiscriminant()))/(a*2);
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập a:");
        double a=Double.parseDouble(sc.nextLine());
        System.out.println("Nhập b:");
        double b=Double.parseDouble(sc.nextLine());
        System.out.println("Nhập c:");
        double c=Double.parseDouble(sc.nextLine());
        QuadraticEquation quadraticEquation=new QuadraticEquation(a,b,c);
        System.out.println(quadraticEquation.toString());
        double delta=quadraticEquation.getDiscriminant();
        if (delta>0){
            System.out.println("nghiệm 1: "+quadraticEquation.getRoot1());
            System.out.println("nghiệm 2: "+quadraticEquation.getRoot2());
        }else if (delta==0){
            System.out.println("phương trình có 1 nghiệm kép : "+quadraticEquation.getRoot1());
        }else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}

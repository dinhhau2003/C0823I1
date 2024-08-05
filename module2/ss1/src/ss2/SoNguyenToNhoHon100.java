package ss2;

public class SoNguyenToNhoHon100 {
    public static void main(String[] args) {
        System.out.println("các số nguyên tố nhỏ hơn 100 là ");
        for (int i=2;i<100;i++){
            if (check(i)){
                System.out.println(i+" ");
            }
        }
    }
    public static boolean check(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

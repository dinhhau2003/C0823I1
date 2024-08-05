package ss5;

import java.util.Arrays;
import java.util.Collections;

public class Text {
    public static void main(String[] args) {
        System.out.println(getArray());
//        int[] array = new int[255];
//        Arrays.setAll(array, i -> i + 1);
//        System.out.println(Arrays.toString(array));
    }
    public static int[] getArray() {
        int[] arr = new int[255];
        for(int i=1;i<=arr.length;i++){
            arr[i-i]=arr[i];
        }
        // code here
        return arr;
    }
}

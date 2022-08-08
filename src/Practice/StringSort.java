package Practice;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    public static void main(String[] args) {
        String s = "Hi hello hola gola bhola ola good";
        String[] arr = s.split(" ");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Comparator.comparingInt(String :: length));
        System.out.println(Arrays.toString(arr));
        char [] charArray = arr[1].toCharArray();
        System.out.println(Arrays.toString(charArray));


    }
}

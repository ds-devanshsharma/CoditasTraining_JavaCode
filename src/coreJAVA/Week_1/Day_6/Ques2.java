package coreJAVA.Week_1.Day_6;
// Question 2: printing Ascending & descending Array
import java.util.Arrays;
import java.util.Collections;

class Ques2Code{
    static void printAscendingOrder(Integer[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void printDescendingOrder(Integer[] arr){
        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
public class Ques2 {
    public static void main(String[] args) {
        Integer[] arr ={110,115,109,112,100};
        Ques2Code.printAscendingOrder(arr);
        /*
        [100, 109, 110, 112, 115]
         */
        Ques2Code.printDescendingOrder(arr);

        /*
        [115, 112, 110, 109, 100]
         */
    }
}

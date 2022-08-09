package coreJAVA.Day_6;
//Question 2 : Copy one to Other using built-in function
import java.util.Arrays;

class Ques3Code{
    //copyArray mehtod is using Array.copyof();
    static void copyArray(int[] arr){
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr2));
    }
}
public class Ques3 {
    public static void main(String[] args) {
        int[] arr ={111,101,103,109,107};
        Ques3Code.copyArray(arr);
        /*
        [111, 101, 103, 109, 107]
         */
    }
}

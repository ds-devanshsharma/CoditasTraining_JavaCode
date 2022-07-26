package coreJAVA.Week_1.Day_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// nth index element of array
class Ques6Code{
    static int NthLargestElement(Integer[] arr,int index){
        Arrays.sort(arr, Collections.reverseOrder());
        return arr[index-1];
    }
}
public class Ques6 {
    public static void main(String[] args) {
        Integer[] arr = {101,102,103,104,105,106,107,108,109,110};
        System.out.println("Enter WhichEver largest you want : ");

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println(index+"th largest in array is : "+Ques6Code.NthLargestElement(arr,index));
        /*
        Enter WhichEver largest you want :
        1
        1th largest in array is : 110
         */
    }
}

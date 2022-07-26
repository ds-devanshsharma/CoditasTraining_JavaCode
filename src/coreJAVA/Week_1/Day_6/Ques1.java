package coreJAVA.Week_1.Day_6;

import java.util.Arrays;
public class Ques1 {
    public static void main(String[] args) {
        int[] arr1 =new int[10];
        //1- Arrays.fills()
        Arrays.fill(arr1,10);
        //2- to print whole Array in go
        System.out.println(Arrays.toString(arr1));
        /*
        [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
         */

        int[] arr ={101,103,102,105,100};
        //3- Arrays.sort();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        /*
        [100, 101, 102, 103, 105]
         */

        //4- equals() :Checks if both the arrays are equal or not
        System.out.println(arr.equals(arr1));
        //false
        System.out.println(Arrays.equals(arr,arr1));
        //false

        //5- hashCode() return hashCode of array instance actually it is memory address of Array instance
        System.out.println(arr.hashCode());
        //1480010240

        // Arrays.copyOf() this method is used to make a copy of given array
        int[] newArr =Arrays.copyOf(arr,arr.length);
        System.out.println("Copied Array is : "+Arrays.toString(newArr));
        /*
            Copied  Array is : [100, 101, 102, 103, 105] same array as arr that we have copied
         */
        //there are many more Arrays method needed to explore
    }
}

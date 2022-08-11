package StringPractice;

import java.util.Arrays;

/**
 * Write an application that accepts a string and an integer n as input, prints the string, rotates it n words to the right, and prints it again.
 * For example,
 * Input -
 * here is a good example for this 3
 * Output -
 * here is a good example for this
 * example for this here is a good
 */
public class WordRotation {
    public static void wordRotate(String[] array , int beginIndex ,int endIndex){
        int start = beginIndex;
        int end = endIndex;
        while(start < end){
            String  temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        String string = "here is a good example for this";
        int k = 3;
        String[] array = string.split(" ");
        wordRotate(array,0, array.length - 1);
        wordRotate(array,0, k-1);
        wordRotate(array,k, array.length-1);

        System.out.println(Arrays.toString(array));

    }
}
/*
[example, for, this, here, is, a, good]
 */
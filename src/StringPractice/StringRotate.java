package StringPractice;

import java.util.Arrays;

/**
 * Write a program that rotates a given string n characters to the right.
 * For example, if the input to your program is rotatemeplease 4,
 * then the output is easerotatemepl
 */
public class StringRotate {
    public static void rotate(char[] array ,int beginIndex , int endIndex){
int start = beginIndex;
int end = endIndex;
while(start < end){
    char temp = array[start];
    array[start] = array[end];
    array[end] = temp;
    start++;
    end--;
}
    }
    public static void main(String[] args) {
        String inputString = "rotatemeplease";
        int rotationCount = 4;
        char[] charArray = inputString.toCharArray();
        System.out.println(Arrays.toString(charArray));
        //logic
        rotate(charArray,0,charArray.length-1);
        rotate(charArray,0,rotationCount-1);
        rotate(charArray,rotationCount,charArray.length-1);

        // printing result
        System.out.println(Arrays.toString(charArray));
    }
}
/*
[r, o, t, a, t, e, m, e, p, l, e, a, s, e]
[e, a, s, e, r, o, t, a, t, e, m, e, p, l]
 */
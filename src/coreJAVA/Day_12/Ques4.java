package coreJAVA.Day_12;
/**
 * 4)   Remove both leading and trailing white space characters from the given string and
 *      also showcase the Unicode value of the character present at index 5.
 */
public class Ques4 {
    public static void main(String[] args) {
        String str = "  Devansh Sharma  ";
        System.out.println("With spaces : "+str);
        //trim() removes spaces from leading and trailing position
        System.out.println("Without spaces : "+str.trim());
        System.out.println("Unicode Value of "+str.charAt(5)+ " is : "+str.codePointAt(5));
    }
}
/*
With spaces :   Devansh Sharma
Without spaces : Devansh Sharma
Unicode Value of a is : 97
 */


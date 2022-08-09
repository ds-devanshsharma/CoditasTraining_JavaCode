package coreJAVA.Day_12;

import java.util.Arrays;

/**
 * 2) Count the total number of vowels and consonants in a string
 */
public class Ques2 {

    public static void main(String[] args) {
        String str = new String("Coditas IT Solutions");
         int vowels = 0;
         int space =0;

        str.toLowerCase();
        //counting vowels
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' ||str.charAt(i)=='e'||str.charAt(i)=='i' ||str.charAt(i)=='o'||
                    str.charAt(i)=='u'){
                vowels++;
            }
            else if (str.charAt(i)==' ') {
                space++;
            }
        }
        // making count of consonants
        int consonents = str.length()-vowels-1-space;
        System.out.println("Number od Vowels are : "+vowels);
        System.out.println("Number of Consonents are : "+consonents);

    }
}

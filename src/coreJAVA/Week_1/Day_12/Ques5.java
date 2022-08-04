package coreJAVA.Week_1.Day_12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5)Accept 5 names of string type, count the length.and as per their length assign there
 * order (Ascending).
 * =>Replace above strings "vowel characters" with their next letter.
 * =>Ex. "Aarti" => Vowels present here are = =>a(2),i(1)
 * =>next character of "a" is "b" and for "i" its "j"
 * ->so,final string will be "bbrti"
 */

public class Ques5 {
    public static void takeInput(String [] array){
        Scanner scan =new Scanner(System.in);
        for(int i=0 ; i< array.length;i++){
            array[i] =scan.next();
        }
    }
    public static String changeName(String name){
       name.toLowerCase();
       for(int i=0;i<name.length();i++){
           if(name.charAt(i)=='a' ||name.charAt(i)=='e'||name.charAt(i)=='i' ||name.charAt(i)=='o'||
                   name.charAt(i)=='u'){
               int a =name.charAt(i);
               name=name.replace(name.charAt(i),(char)(a+1));
           }

       }
        return name;
    }
    public static void main(String[] args) {
        int count=5;
        String  names[] = new String [count];
        takeInput(names);
        System.out.println(Arrays.toString(names));
        //taking oneByOne and checking vowel if there changing it
        int i=0;
        for(String name : names) {
            names[i++]=changeName(name);

        }
        System.out.println(Arrays.toString(names));


    }
}
/*
devansh
manish
arti
zulfa
sharma
[devansh, manish, arti, zulfa, sharma]
[dfvbnsh, mbnjsh, brtj, zvlfb, shbrmb]

 */

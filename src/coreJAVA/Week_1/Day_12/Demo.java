package coreJAVA.Week_1.Day_12;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        String str = " GeekforGeeks";
        HashSet<Character> hashSet = new HashSet();

         for(int i=0;i<str.length();i++)
         {
             hashSet.add(str.charAt(i));
         }
        System.out.println(str+"\n");
         for(Character i : hashSet)
         {
             System.out.println(i);
         }
    }
}

package coreJAVA.Day_12;
/**
 * 3) Remove all repeated characters from a given string.
 */
public class Ques3 {
    public static void main(String[] args) {
        String str = "RepeatedCharactors";
        String ans = "";
        for(int i=0;i<str.length();i++){
          if(ans.indexOf(str.charAt(i))<0){
              ans+=str.charAt(i);
          }
        }
        System.out.println("With spaces : "+str);
        System.out.println("Without spaces : "+ans);
    }
}
/*
With spaces : RepeatedCharactors
Without spaces : RepatdChrcos
 */
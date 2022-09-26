package Practice.StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        String str = "Hi 1i 5am 8Devan9sh My Insta9gram han0dle is mr.devil1522 !";
        StringTokenizer tokenizer = new StringTokenizer(str, "0123456789",false);
//        System.out.println(tokenizer.countTokens());
//        System.out.println(tokenizer.nextToken());
//        10
//        Hi
//        tokenizer=new StringTokenizer(str); to start again from beginning
        System.out.println("_________________________________");
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }
}
/*
Hi
i
am
Devan
sh My Insta
gram han
dle is mr.devil
 !
 */
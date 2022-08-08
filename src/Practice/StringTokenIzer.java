package Practice;

import java.util.StringTokenizer;

public class StringTokenIzer {
    public static void main(String[] args) {
        String str = "HI I AM DEVANSH SHARMA FROM KANPUR !!";
        StringTokenizer tokenizer = new StringTokenizer(str," ");
        System.out.println(tokenizer.countTokens());
        System.out.println(tokenizer.toString());
        while(tokenizer.nextToken()!=null){
            System.out.println(tokenizer.nextToken());
        }


    }
}

package Practice;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        HashSet<String> set = new HashSet<>();
        for (String item : words) {
            String ans="";
            for (int i = 0; i < item.length(); i++) {
                ans += morse[item.charAt(i) -'a'];
            }
            set.add(ans);
        }
        System.out.println(set);
        return set.size();
    }
}

public class Test {
    public static void main(String[] args) {
    String[] words = {"noilq","kzlq","ydreq","ybxk","kzlq"};
        System.out.println(new Solution().uniqueMorseRepresentations(words));
    }
}

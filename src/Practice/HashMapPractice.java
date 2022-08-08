package Practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            else
                hashMap.put(s.charAt(i),1);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
       // hashMap.

    }
}

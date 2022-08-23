package coreJAVA.Day_19_Collection;

import java.util.HashMap;

//class HashMapUse{
//    public void count
//}
public class FreqOfAlphates {
    public static void main(String[] args) {
        String string ="Devansh Sharma" ;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0 ; i<string.length() ;i++ ){
            if(map.containsKey(string.charAt(i))){
                map.put(string.charAt(i) , map.get(string.charAt(i))+1);
            }
            else{
                map.put(string.charAt(i),1);
            }
        }
        System.out.println(map);
    }
}

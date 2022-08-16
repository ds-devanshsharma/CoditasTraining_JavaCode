package StringPractice;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Code{
    public static  String  caseSort(String str)
    {
        List<Character> upCase = new ArrayList<>();
        List<Character> lowCase = new ArrayList<>();
        int[] marker = new int[str.length()];
        for(int i=0 ;i<str.length();i++ ){
            char ch = str.charAt(i);
            if(ch >= 65 && ch <=90){
                upCase.add(ch);
                marker[i] = 1;
            }
            else
                lowCase.add(ch);
        }
        Collections.sort(upCase);
        Collections.sort(lowCase);
        String ans = "";
        for(int i=marker.length-1 ; i>=0 ; i--){
            if(marker[i]>0){
                ans = upCase.get(upCase.size()-1)+ ans;
                upCase.remove(upCase.size()-1);
            }else{
                ans = lowCase.get(lowCase.size()-1)+ ans;
                lowCase.remove(lowCase.size()-1);
            }
        }
        return ans;
    }
}
public class GFGSort {
    public static void main(String[] args) {
        String string = "defRTSersUXI";
        System.out.println(Code.caseSort(string));

    }
}
//deeIRSfrsTUX
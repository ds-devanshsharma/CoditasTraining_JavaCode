package StringPractice;
/**
 * Get the third character of each string from given string array
 * If the third character not present append '$' and return the output in upper case
 *
 * Sample input -> String input[]={"akash","pavan","ac","satish","ram","go"};
 * Expected Output -> "AV$TM$”
 */
public class ThirdElement {
    public static void main(String[] args) {
        String input[]={"akash","pavan","ac","satish","ram","go"};
        String ans = "";
        for(String string : input){
            if(string.length()>2)
                ans += string.charAt(2);
            else
                ans += "$";
        }
        System.out.println(ans.toUpperCase());
    }
}
/*
AV$TM$
 */
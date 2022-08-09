package coreJAVA.Day_13;
/**
 *  String into int
 */
public class Ques2{
    public static void main(String[] args) {
        String string = "number";
       try{
           System.out.println("Before exception !");
          int number = Integer.parseInt(string);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
/*
Before exception !
java.lang.NumberFormatException: For input string: "number"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:668)
	at java.base/java.lang.Integer.parseInt(Integer.java:784)
	at coreJAVA.Week_1.Day_13.Ques3.main(Ques3.java:8)

NumberFormatException is unchecked Exception that occurs whenever number is expected and other dataType is passed.
 */
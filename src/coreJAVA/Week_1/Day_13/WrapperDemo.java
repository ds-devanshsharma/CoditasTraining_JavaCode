package coreJAVA.Week_1.Day_13;

public class WrapperDemo {
    public static void main(String[] args) {
        int a =10;
        Integer b = a;
        int c = b;
        Integer num =100 ;
        String name = "D";
        int d = Integer.parseInt(name);
        System.out.println(d);
    }
}
/*
Exception in thread "main" java.lang.NumberFormatException: For input string: "D"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:668)
	at java.base/java.lang.Integer.parseInt(Integer.java:784)
	at coreJAVA.Week_1.Day_13.WrapperDemo.main(WrapperDemo.java:10)
 */
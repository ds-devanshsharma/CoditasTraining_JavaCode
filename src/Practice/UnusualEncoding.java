package Practice;

/**
 * Unusual Encoding
 * Write a program that reads 10 single-digit integers and displays a string consisting of 10 characters using the coding scheme:
 * Digit 		Character
 * 0 		a
 * 1 		b
 * 2 		c
 * … 		…
 * 9 		j
 * For example, if input consists of the 10 digits 1 8 6 1 0 3 1 8 5 5, the application
 * responds with "bigbadbiff."
 */
public class UnusualEncoding {
    public static void encodeGenerater(long number ){
        String numberString = Long.toString(number);
        for(int i=0 ;i< numberString.length();i++){
////            char
////            int n = Integer.parseInt();
//            System.out.println((char)n);
        }
    }
    public static void main(String[] args) {
        encodeGenerater(1861031855);
    }
}

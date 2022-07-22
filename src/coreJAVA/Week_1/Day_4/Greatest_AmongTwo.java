package coreJAVA.Week_1.Day_4;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
class Greatest_AmongTwo_code{
    public  int greater(int a, int b){
        return a>b ? a : b;
    }
}
public class Greatest_AmongTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        Greatest_AmongTwo_code greatest_amongTwo_code = new Greatest_AmongTwo_code();
        System.out.println("Greater one is :" + greatest_amongTwo_code.greater(num1, num2));
    }
}
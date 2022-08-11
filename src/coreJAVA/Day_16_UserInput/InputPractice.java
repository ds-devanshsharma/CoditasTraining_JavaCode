package coreJAVA.Day_16_UserInput;

import java.util.Scanner;

public class InputPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String name = scanner.next();
        System.out.println(id+" "+name);
    }
}

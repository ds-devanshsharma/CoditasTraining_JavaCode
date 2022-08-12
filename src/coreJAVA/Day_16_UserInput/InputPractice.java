package coreJAVA.Day_16_UserInput;

import java.io.Console;
import java.util.Scanner;

public class InputPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String name = scanner.next();
        System.out.println(id+" "+name);
    }
}
class ConsoleDemo2{
    public static void main(String[] args) {
        Console console = System.console();
        int id = Integer.parseInt(console.readLine());
        System.out.println(id);
    }
}

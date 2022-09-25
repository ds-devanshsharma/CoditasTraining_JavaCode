package Practice.ExceptionHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println("Enter number less than 100");
        if(Integer.parseInt(reader.readLine())>100){
            throw new ArithmeticException("NUmber bda hai !\n" +
                    "Chota daal!!");
        }
    }
}

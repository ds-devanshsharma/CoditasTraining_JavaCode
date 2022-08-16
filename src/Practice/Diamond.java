package Practice;

import java.util.Scanner;

public class Diamond {
    public static void daimondPrinter(int n){
        for(int i=1 ; i<= n ;i++){
            int spaces = n-i;
            int stars = 2*i -1;
            while(spaces > 0){
                System.out.print(" ");
                spaces --;
            }

            while(stars > 0){
                System.out.print("*");
                stars--;
            }
            System.out.println();
        }
        for(int i=n-1 ; i>=1 ;i--){
            int spaces = n-i;
            int stars = 2*i -1;
            while(spaces > 0){
                System.out.print(" ");
                spaces --;
            }

            while(stars > 0){
                System.out.print("*");
                stars--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter number : " );
        int number = scanner.nextInt();
        daimondPrinter(number);
    }
}

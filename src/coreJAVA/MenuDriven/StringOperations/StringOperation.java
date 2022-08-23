package coreJAVA.MenuDriven.StringOperations;

import java.util.Scanner;

class StringOperation {
    String string ;
    String string1;
    String string2;
    public  void lengthOfString(Scanner scanner){
        System.out.println("Enter any String : ");
         string = scanner.nextLine();
        System.out.println("Length of String : "+string + " :: is :: "+string.length());
    }

    public  void concatString(Scanner scanner) {
        System.out.println("Enter String 1 : ");
         string1 = scanner.nextLine();
        System.out.println("Enter String 2 : ");
         string2 = scanner.nextLine();
        System.out.println("Concatinated String is : " + (string1 = string1+string2));
    }
    public  void compareString(Scanner scanner){
        System.out.println("Enter String 1 : ");
         string1 = scanner.nextLine();
        System.out.println("Enter String 1 : ");
         string2 = scanner.nextLine();
        System.out.println(string1.equals(string2));
    }
    public  void trimString(Scanner scanner){
        System.out.println("Enter any String : ");
         string = scanner.nextLine();
        System.out.println("Trimmed String : "+ string.trim());
    }
}

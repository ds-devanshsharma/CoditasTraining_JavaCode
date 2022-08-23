package coreJAVA.MenuDriven.StringOperations;
import java.util.Scanner;
public class MenuDrivenStringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringOperation operation = new StringOperation();
        System.out.println("1: Length Of String");
        System.out.println("2: String Concatenation");
        System.out.println("3: String Comparison");
        System.out.println("4: String Trimming");
        System.out.println("5: Quit");
        do {
            System.out.println("Enter your Choice !!");
            int operationChoice = scanner.nextInt();
            scanner.nextLine();
            switch(operationChoice){
                case 5 :
                    System.exit(1);
                case 1 :
                    operation.lengthOfString(scanner);
                    break;
                case 2 :
                    operation.concatString(scanner);
                    break;
                case 3 :
                    operation.compareString(scanner);
                    break;
                case 4 :
                    operation.trimString(scanner);
                default:
                    System.out.println("Wrong Entry !!");
            }

        }while(true);

    }
}

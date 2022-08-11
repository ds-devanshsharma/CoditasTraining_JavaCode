package coreJAVA.Day_16_UserInput;

import java.util.Scanner;

/* demo for spaceConflict in Scanner next() method
REASON :
 case :1
        * THIS INPUTMISSMATCHEXCEPTION HAPPENING BEACAUSE OF SCANNER CLASS NEXT()
        NEXT() TAKES ONLY ONE WORD UPTO SPACE FOUND
        AND HERE WE ARE TRYING TO TAKE "dVANSH SHARMA" TWO WORD THEN
        NEXT() TAKES ONLY ONE WORD AND KEEP SECOND WORD ON HOLD FOR OTHER INPUT
        * IF WE TAKE INT JUST AFTER STRING THEN IT WILL SHOW YOU InputMismatchException
        * to resolve this we can do nextLine() or clear buffer by nextLine() method
 case :2 nextInt()
         nextLine(); for handling \n Enter stroke
         nextLine(); actual use
 */
public class SpaceConflict {
    int id;
    String name;
    float marks;
    public void inputDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks : ");
        marks = scanner.nextFloat();
        System.out.println("Enter your Name :: ");
         name = scanner.next();
        // scanner.nextLine();
        System.out.println("Enter your Id : ");
         id = scanner.nextInt();

        System.out.println("name : "+name + "\nid : "+id+"\nMarks : "+marks );
    }
    public void displayDetails(){
        System.out.println("Id : "+ id+"\nname : "+name+"\nmarks : "+marks);
    }
    public static void main(String[] args) {
        SpaceConflict spaceConflict = new SpaceConflict();
        spaceConflict.inputDetails();
        spaceConflict.displayDetails();
    }
}
/*
Enter your Name ::
Devansh sharma
Enter your Id :
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:943)
	at java.base/java.util.Scanner.next(Scanner.java:1598)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2263)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2217)
	at coreJAVA.Day_16_UserInput.SpaceConflict.inputDetails(SpaceConflict.java:15)
	at coreJAVA.Day_16_UserInput.SpaceConflict.main(SpaceConflict.java:25)
REASON :    * THIS INPUTMISSMATCHEXCEPTION HAPPENING BEACAUSE OF SCANNER CLASS NEXT()
            NEXT() TAKES ONLY ONE WORD UPTO SPACE FOUND
            AND HERE WE ARE TRYING TO TAKE "dVANSH SHARMA" TWO WORD THEN
            NEXT() TAKES ONLY ONE WORD AND KEEP SECOND WORD ON HOLD FOR OTHER INPUT
            * IF WE TAKE INT JUST AFTER STRING THEN IT WILL SHOW YOU InputMismatchException
            * to resolve this we can do nextLine() or clear buffer by nextLine() method
 */
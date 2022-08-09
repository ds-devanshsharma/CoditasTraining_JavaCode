package coreJAVA.Day_14_Bank;

import java.util.Scanner;

/**
 * 1 Write a program for::below cases to handle wrong operations done by customers in
 * deposit, and withdrawal operations.
 * Case 1)CREATE an InvalidAmountException if the user enters zero or -ve amount in deposit
 * and withdraw operations
 * Case 2)Throw InsufficientBalanceException if the user enters the amount greater than the
 * balance in case of withdrawing operations
 */
public class Ques1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which type of transaction You want to perform  : \n" +
                "Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :");
        while(true) {
            int transactiontype = scanner.nextInt();

            switch (transactiontype) {
                case 1:
                    System.out.println("Enter your Deposit Amount :");
                    bank.depositAmount(scanner.nextInt());
                    System.out.println("Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :");
                    break;
                case 2:
                    System.out.println("Enter your Withdraw Amount :");
                    bank.withdrawAmount(scanner.nextInt());
                    System.out.println("Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :");
                    break;
                default:
                    System.out.println("Exit !!");
            }
            if(transactiontype == 3 ) break;

        }
    }
}
/*
Which type of transaction You want to perform  :
Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :
1
Enter your Deposit Amount :
45000
Amount 45000 : added to Your Account successfully !!
Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :
2
Enter your Withdraw Amount :
5000
balance left in Your account : 40000
Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :
2
Enter your Withdraw Amount :
20000
balance left in Your account : 20000
Enter 1 for Deposit & Enter 2 for withdraw & Enter 3 for Exit :
3
Exit !!

Process finished with exit code 0

 */
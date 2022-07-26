package coreJAVA.Week_1.Day_6;
//question1 : bank system
class Bank{
    /* here i am trying to implement banking system with password
     credential if credential is correct user can check,or set balance otherwise
     */
    private int balance;

    public int getBalance(int password) {
        if(password==123)
            return balance;
        System.out.println("Please Enter Valid Credential ");
        return 0;
    }

    public void setBalance(int balance ,int password) {
       if(password==123) this.balance = balance;

    }
}
public class Encapsulation_Ques1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setBalance(10000,123);
         // now value has been set to 10000 because password in matching
        System.out.println("Your current Balance is : "+bank.getBalance(123));
        /*
        Your current Balance is : 10000
         */
        System.out.println("Your current Balance is : "+bank.getBalance(124));
        /*
        Please Enter Valid Credential
        Your current Balance is : 0
         */

    }
}

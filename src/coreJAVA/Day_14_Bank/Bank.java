package coreJAVA.Day_14_Bank;
public class Bank{
   static int balance ;
    // depositAmount() for deposit
    public void depositAmount(int amount)  {

        if(amount <= 0){
            try {
                throw new InvalidAmountException(amount);
            } catch (InvalidAmountException e) {
                e.printStackTrace();
            }
        }else{
            this.balance= amount;
            System.out.println("Amount "+amount+" : added to Your Account successfully !!");
        }
    }

    // WithdrawAmount() for Withdraw
    public void withdrawAmount(int withdrawAmount)  {
        if(withdrawAmount <= 0){
            try {
                throw new InvalidAmountException(withdrawAmount);
            } catch (InvalidAmountException e) {
               e.printStackTrace();
            }
        } else if (withdrawAmount > balance) {
            try {
                throw new InsufficientBalanceException();
            } catch (InsufficientBalanceException e) {
               e.printStackTrace();
            }
        }
        else{
            balance-= withdrawAmount;
            System.out.println("balance left in Your account : "+balance);
        }
    }
}
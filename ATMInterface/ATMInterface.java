package ATMInterface;

import java.util.Scanner;

public class ATMInterface {
    public class UserAccount {
        double minimumBalance = 1000;
        double balance = minimumBalance;
        int userPinNumber = 1234;
    }
    public class ATM extends UserAccount {
        public double DepositAmt;
        public double WithdrawAmt;
        private int userPin;

        private boolean authorizedUser() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your four digit PIN Number :");
            userPin = scanner.nextInt();
            if (userPin == userPinNumber) {
                return true;
            }
            else {
                return false;
            }
        }

        private void checkBalance()
        {
            if (authorizedUser()) {
                System.out.println("Your current balance is Rs."+ balance);
            }
            else {
                System.out.println("Invalid PIN");
                checkBalance();
            }
        }
    
        private void Deposit()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How much amount do you want to deposit?");
            DepositAmt = scanner.nextInt();
            if (authorizedUser()) {
               balance += DepositAmt;
               System.out.println("Amount Deposited Successfully!");
               System.out.println("Account Balance: "+balance);
            }
            else {
                System.out.println("Invalid PIN \nTransaction Failed");
            }
        }
    
        private void Withdrawal()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How much do you want to Withdraw?");
            WithdrawAmt = scanner.nextInt();
            if (authorizedUser()) {

                if(WithdrawAmt > balance)
                {
                    System.out.println("Insufficient balance!");
                    System.out.println("Balance Ammount: "+balance);
                }
                else
                {
                    balance -= WithdrawAmt;
                    System.out.println("Amount Withdrawed successfully!");
                    System.out.println("Updated balance amount is: " + balance);
                }
            }
            else {
                System.out.println("Invalid PIN \nTransaction Failed");
            }
        }
        
    }

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        ATMInterface x = new ATMInterface();
        ATM ATMMachine = x.new ATM();
        int choice = 0;
        while(choice!=4)
        {
            System.out.println("Welcome to your Bank! How can we serve you ? ");
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1: ATMMachine.checkBalance();
                        break;
                case 2: ATMMachine.Deposit();
                        break;
                case 3: ATMMachine.Withdrawal();
                        break;
                case 4: System.out.println("Transaction Complete");
                        break;
                default: System.out.println("Invalid choice! Enter a valid choice");
            }
            System.out.println("Thank you!");
        }
        scanner.close();
    }
}
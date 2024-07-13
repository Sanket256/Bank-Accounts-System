package com.Account.Bank;

//////////////////////////////// Account Class /////////////////////////////////
public class Account {
    int accountNumber;
    String accountHolderName;
    double balance;

    ///////////////////////// Default Constructor  ////////////////////////////////
    public Account() {
        // Default constructor
    }

    /////////////////////// Parameterized Constructor //////////////////////////////
    public Account(int v1, String v2, double v3) {
        this.accountNumber = v1;
        this.accountHolderName = v2;
        this.balance = v3;
    }

    ///////////////////// Use Setter and Getter Method ////////////////////////////
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int v1) {
        this.accountNumber = v1;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String v2) {
        this.accountHolderName = v2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double v3) {
        this.balance = v3;
    }

    ////////////////////////////// Deposit Function //////////////////////////////
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("\nDeposit of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("\nInvalid deposit amount. Please enter a positive value...");
        }
    }

    ///////////////////////////////// Withdraw Function /////////////////////////////////
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("\nWithdrawal unsuccessful...");
        } else {
            balance = balance - amount;
            System.out.println("\nWithdrawal of " + amount + " successfully... New balance: " + balance);
        }
    }

    ///////////////////////////////// Display Function /////////////////////////////////
    public void displayAccountDetails() {
        System.out.println("\n======> || Account Details || <=======");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    ///////////////////////// CalculateInterest Function ////////////////////////////////
    public void calculateInterest(double interestRate) {
        double interest = balance * interestRate;
        System.out.println("\nInterest calculated: " + interest);
    }
}

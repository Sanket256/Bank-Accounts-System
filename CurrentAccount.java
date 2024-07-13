package com.Account.Bank;

////////////////////////// class currentAccount //////////////////////////////
public class CurrentAccount extends Account {
    double overdraftLimit = 5000;

    /////////////////////////// Default constructor //////////////////////////////
    public CurrentAccount() {
        // Default constructor
    }

    ////////////////////////// Parameterized constructor //////////////////////////
    public CurrentAccount(int v1, String v2, double v3, double v4) {
        super(v1, v2, v3);
        this.overdraftLimit = v4;
    }

    ////////////////////// Use Setter and Getter Method ////////////////////////////
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit >= 0) {
            this.overdraftLimit = overdraftLimit;
            System.out.println("\nOverdraft limit set to: " + overdraftLimit);
        } else {
            System.out.println("\nInvalid overdraft limit. Please enter a non-negative value...");
        }
    }

    /////////////////////////// Withdraw Function To @Override ////////////////////////////////
    @Override
    public void withdraw(double amount) {
        if (amount > getBalance() + overdraftLimit) {
            System.out.println("\nWithdrawal unsuccessful. Exceeds available balance and overdraft limit.");
        } else {
            super.withdraw(amount);
        }
    }

    ///////////////////////// Display Function //////////////////////////////
    public void displayCurrentAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

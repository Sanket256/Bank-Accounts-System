package com.Account.Bank;

//////////////////////////// class SavingAccount ///////////////////////////////
public class SavingAccount extends Account {
    private double minimumBalance = 10000;
    private double interestRate = 0.02;

    /////////////////////////// Default constructor //////////////////////////////
    public SavingAccount() {
        // Default constructor
    }

    ////////////////////// Parameterized constructor ////////////////////////////
    public SavingAccount(int v1, String v2, double v3, double v4, double v5) {
        super(v1, v2, v3);
        this.minimumBalance = v4;
        this.interestRate = v5;
    }

    //////////////////// Use Setter and Getter Method ////////////////////////////
    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //////////////////// Withdraw Function To @Override //////////////////////////
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < minimumBalance) {
            System.out.println("\nWithdrawal unsuccessful. Minimum balance requirement not met.");
        } else {
            super.withdraw(amount);
        }
    }

    //////////////////// AddInterest Function /////////////////////////////////////
    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("\nInterest added to the account: " + interest);
    }

    //////////////////// Display Function /////////////////////////////////////////
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Minimum Balance: " + minimumBalance);
        System.out.println("Interest Rate: " + interestRate);
    }
}

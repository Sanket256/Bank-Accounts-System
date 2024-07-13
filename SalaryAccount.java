package com.Account.Bank;

//////////////////////////// class SalaryAccount ///////////////////////////////
public class SalaryAccount extends Account {
    private int transactionLimit = 2;

    /////////////////////////// Default constructor //////////////////////////////
    public SalaryAccount() {
        // Default constructor
    }

    ////////////////////// Parameterized constructor ////////////////////////////
    public SalaryAccount(int v1, String v2, double v3, int v4) {
        super(v1, v2, v3);
        this.transactionLimit = v4;
    }

    //////////////////// Use Setter and Getter Method ////////////////////////////
    public int getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(int transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    //////////////////// Withdraw Function To @Override //////////////////////////
    @Override
    public void withdraw(double amount) {
        if (transactionLimit > 0) {
            super.withdraw(amount);
            transactionLimit--;
        } else {
            System.out.println("\nWithdrawal unsuccessful. Transaction limit exceeded.");
        }
    }

    /////////////////////////// Display Function /////////////////////////////////
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Transaction Limit: " + transactionLimit);
    }
}

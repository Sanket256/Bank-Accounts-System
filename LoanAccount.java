package com.Account.Bank;
//////////////////////////// class loanAccount ///////////////////////////////
public class LoanAccount extends Account 
{
    double loanInterestRate = 0.05;
/////////////////////////// Default constructor //////////////////////////////
    public LoanAccount() 
    {
        // Default constructor
    }
////////////////////// Parameterize constructor //////////////////////////////
    public LoanAccount(int v1, String v2, double v3, double v4) 
    {
        super(v1, v2, v3);
        this.loanInterestRate = v4;
    }
//////////////////// Use Setter and Getter Method  ////////////////////////////
    public double getLoanInterestRate() 
    {
        return loanInterestRate;
    }
    public void setLoanInterestRate(double loanInterestRate) 
    {
        this.loanInterestRate = loanInterestRate;
    }
//////////////////////// Deposit Function To @Override ////////////////////////////////
    public void deposit(double amount) 
    {
        if (amount < 0) 
        {
            System.out.println("\nInvalid deposit amount for a loan account.");
        } 
        else 
        {
            super.deposit(amount);
            calculateLoanInterest();
        }
    }
/////////////////////////////// CalculateInterest Function ////////////////////////////////
    private void calculateLoanInterest() 
    {
        double interest = getBalance() * loanInterestRate;
        System.out.println("\nLoan interest calculated: " + interest);
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
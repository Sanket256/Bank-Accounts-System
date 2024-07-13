package com.Account.Bank;

import java.util.Scanner;

////////////////////////////// Start Main Function //////////////////////////////////
public class Main {
    static final int Max_Accounts = 100;
    static Account[] accounts = new Account[Max_Accounts];
    static int accountCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    openAccount();
                    break;
                case 2:
                    closeAccount();
                    break;
                case 3:
                    performTransaction();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    calculateInterestRate();
                    break;
                case 6:
                    takeLoan();
                    break;
                case 7:
                    loanPaid();
                    break;
                case 8:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please enter a valid option.");
            }
        } while (true);
    }

    ///////////////////////////// Display Menu Function ////////////////////////////
    private static void displayMenu() {
        System.out.println("\n|------------------------------------------------|");
        System.out.println("|========>|| Bank Application System  ||<========|");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-1. Open a Account                        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-2. Close a Account                       |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-3. Perform Transaction                   |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-4. Generate a Report                     |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-5. Calculate Interest Rate               |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-6. Take Loan                             |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-7. Loan Paid                             |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-8. Exit                                  |");
        System.out.println("|------------------------------------------------|");
    }

    ///////////////////////////// Open Account Function ////////////////////////////
    private static void openAccount() {
        if (accountCount < Max_Accounts) {
            displayOpenAccountMenu();
            System.out.print("\nEnter your choice: ");
            int accountType = sc.nextInt();

            System.out.print("\nEnter account number: ");
            int accountNumber = sc.nextInt();
            System.out.print("Enter account holder name: ");
            String accountHolderName = sc.next();
            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();

            switch (accountType) {
                case 1:
                    accounts[accountCount++] = new SavingAccount(accountNumber, accountHolderName, balance, 10000, 0.02);
                    break;
                case 2:
                    accounts[accountCount++] = new SalaryAccount(accountNumber, accountHolderName, balance, 2);
                    break;
                case 3:
                    accounts[accountCount++] = new CurrentAccount(accountNumber, accountHolderName, balance, 5000);
                    break;
                case 4:
                    accounts[accountCount++] = new LoanAccount(accountNumber, accountHolderName, balance, 0.05);
                    break;
                default:
                    System.out.println("\nInvalid account type. Please select a valid option...");
            }
            System.out.println("\nAccount created successfully...");
        } else {
            System.out.println("\nMaximum number of accounts reached. Cannot open a new account...");
        }
    }

    private static void displayOpenAccountMenu() {
        System.out.println("\n|------------------------------------------------|");
        System.out.println("|=============> || Open Account || <=============|");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-1. Saving Account                        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-2. Salary Account                        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-3. Current Account                       |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-4. Loan Account                          |");
        System.out.println("|------------------------------------------------|");
    }

    ///////////////////////////// Close Account Function ////////////////////////////
    private static void closeAccount() {
        System.out.print("\nEnter Account number to close: ");
        int accountNumber = sc.nextInt();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                accounts[i] = null;
                System.out.println("\nAccount closed successfully...");
                return;
            }
        }
        System.out.println("\nSorry, your Account was not found!...");
    }

    ///////////////////////////// Perform Transaction Function ////////////////////////////
    private static void performTransaction() {
        System.out.print("\nEnter Account Number To Perform the Transaction: ");
        int accountNumber = sc.nextInt();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                displayTransactionMenu();
                System.out.print("\nEnter your choice: ");
                int transactionChoice = sc.nextInt();

                switch (transactionChoice) {
                    case 1:
                        deposit(accounts[i]);
                        break;
                    case 2:
                        withdraw(accounts[i]);
                        break;
                    default:
                        System.out.println("Invalid transaction choice...");
                }
                return;
            }
        }
        System.out.println("Sorry, your Account was not found!...");
    }

    private static void displayTransactionMenu() {
        System.out.println("\n|------------------------------------------------|");
        System.out.println("|===========> || Transaction Menu || <===========|");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-1. Deposit                              |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| Press-2. Withdraw                             |");
        System.out.println("|------------------------------------------------|");
    }

    private static void deposit(Account account) {
        System.out.print("\nEnter deposit amount: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);
    }

    private static void withdraw(Account account) {
        System.out.print("\nEnter withdrawal amount: ");
        double withdrawalAmount = sc.nextDouble();
        account.withdraw(withdrawalAmount);
    }

    ///////////////////////////// Generate Report Function ////////////////////////////
    private static void generateReport() {
        boolean accountsExist = false;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null) {
                accounts[i].displayAccountDetails();
                accountsExist = true;
            }
        }
        if (!accountsExist) {
            System.out.println("\nNo accounts available to generate a report...");
        }
    }

    ///////////////////////////// Calculate Interest Rate Function ////////////////////////////
    private static void calculateInterestRate() {
        System.out.print("\nEnter Account Number To Calculate Interest Rate: ");
        int accountNumber = sc.nextInt();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                System.out.print("\nEnter interest rate: ");
                double interestRate = sc.nextDouble();
                accounts[i].calculateInterest(interestRate);
                return;
            }
        }
        System.out.println("\nSorry, your Account was not found!...");
    }

    ///////////////////////////// Take Loan Function ////////////////////////////
    private static void takeLoan() {
        System.out.print("\nEnter Account Number To Take a Loan: ");
        int accountNumber = sc.nextInt();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] instanceof LoanAccount && accounts[i].getAccountNumber() == accountNumber) {
                LoanAccount loanAccount = (LoanAccount) accounts[i];

                System.out.print("\nEnter loan amount: ");
                double loanAmount = sc.nextDouble();

                if (loanAmount > 0) {
                    loanAccount.deposit(loanAmount);
                    System.out.println("\nLoan taken successfully...");
                    return;
                } else {
                    System.out.println("\nInvalid loan amount. Please enter a positive value...");
                    return;
                }
            }
        }
        System.out.println("\nLoan account not found for the given account number...");
    }

    ///////////////////////////// Loan Paid Function ////////////////////////////
    private static void loanPaid() {
        System.out.print("\nEnter account number to mark the loan as paid: ");
        int accountNumber = sc.nextInt();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] instanceof LoanAccount && accounts[i].getAccountNumber() == accountNumber) {
                LoanAccount loanAccount = (LoanAccount) accounts[i];

                System.out.print("\nEnter loan amount: ");

                if (!sc.hasNextDouble()) {
                    System.out.println("\nInvalid input. Please enter a valid loan amount...");
                    sc.nextLine();
                    return;
                }
                double loanAmount = sc.nextDouble();
                sc.nextLine();

                loanAccount.setBalance(0);
                System.out.println("\nLoan Marked as Paid Successfully...");
                return;
            }
        }
        System.out.println("\nLoan account not found for the given account number...");
    }
}

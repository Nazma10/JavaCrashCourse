package bankaccountapp;

import java.util.Scanner;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking account
    private String name;
    private String sSN; // Social Security Number
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set common properties and initialize the account
    public Account (String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    // List common methods
    // Generate Account number
    private String setAccountNumber () {
        String lastTwoDigits = sSN.substring(sSN.length()-2, sSN.length());
        index++;
        int uniqueId = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));

        return lastTwoDigits + uniqueId + randomNumber;
    }

    public void compound () {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest: " + accruedInterest);
        getBalance();
    }

    public abstract void setRate ();

    public void deposit () {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Amount to Deposit: ");
        double amount = in.nextDouble();

        balance += amount;
        System.out.println("$" + amount + " deposited Successfully");
        getBalance();
    }

    public void withdraw () {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Amount to Withdraw: ");
        double amount = in.nextDouble();

        if (amount < balance) {
            balance -= amount;
            System.out.println("$" + amount + " Withdrawn Successfully");
            getBalance();
        } else {
            System.out.println("Sorry! Insufficient Account Balance");
        }
    }

    public void transfer () {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String toAccNo = in.nextLine();

        System.out.print("Enter Amount to Transfer: ");
        double amount = in.nextDouble();

        if (amount < balance) {
            balance -= amount;
            System.out.println("Successfully transfer $" + amount + " to " + toAccNo);
            getBalance();
        } else {
            System.out.println("Sorry! Insufficient Account Balance");
        }
    }

    public void getBalance () {
        System.out.println("Your Account balance is $" + balance);
    }

    // Show account info
    public void getAccountInfo () {
        System.out.println(
                "\nAccount Details: " +
                "\nName: " + name +
                "\nsSN: " + sSN +
                "\nAccount Number: " + accountNumber +
                "\nInitial Deposit: " + balance + "\nRate: " + rate + "%"
        );
    }
}

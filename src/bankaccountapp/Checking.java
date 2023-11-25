package bankaccountapp;

public class Checking extends Account {
    // List specific properties
    private int debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize checking account properties
    public Checking (String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;

        setDebitCard();
    }

    // List methods specific to checking account
    private void setDebitCard () {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    public void setRate () {
        rate = getBaseRate() * .15;
    }

    public void getAccountInfo () {
        super.getAccountInfo();
        System.out.println("Account Type: Checking");
        System.out.println("Your Checking Account Features: Debit Card" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPIN);
    }
}

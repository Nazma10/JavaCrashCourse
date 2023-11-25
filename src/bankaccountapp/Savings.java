package bankaccountapp;

public class Savings extends Account {
    // List specific properties
    private int safetyDepositId;
    private int safetyDepositKey;

    // Constructor to initialize savings account properties
    public Savings (String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;

        setSafetyDepositBox();
    }

    // List methods specific to savings account
    private void setSafetyDepositBox () {
        safetyDepositId = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void setRate () {
        rate = getBaseRate() - .25;
    }

    public void getAccountInfo () {
        super.getAccountInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Your Savings Account Features: SafetyBox" +
                "\n Safety Box Id: " + safetyDepositId +
                "\n Safety Box Key: " + safetyDepositKey);
    }
}

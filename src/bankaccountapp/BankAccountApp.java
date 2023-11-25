package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main (String args[]) {

        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Users\\DELL\\Desktop\\NewBankAccounts.csv";

        // Read csv file and create account based on the data
        List <String[]> newAccountHolders = utilities.CSV.read(file);
        System.out.println("New Accounts");
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            System.out.println(name + " " + sSN + " " + accountType);
            double initDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n **********************");
            acc.getAccountInfo();
        }
    }
}

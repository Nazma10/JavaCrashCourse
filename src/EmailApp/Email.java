package EmailApp;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private int defaultPasswordLength = 8;
    private String email;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "stc.com";

    // Constructor to receive the firstname and lastname
    public Email (String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        // Call a method asking for department - return department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that returns password
        this.password = randomPassword(defaultPasswordLength);

        // Combine elements to generate email
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment () {
        System.out.println("Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int code = in.nextInt();

        if (code == 1) {
            return "Sales";
        } else if (code == 2) {
            return "Development";
        } else if (code == 3) {
            return "Accounting";
        } return "";
    }

    // Generate a random password
    private String randomPassword (int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$%&#!";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail (String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword (String password) {
        this.password = password;
    }

    public int getMailboxCapacity () {
        return mailboxCapacity;
    }

    public String getAlternateEmail () {
        return alternateEmail;
    }

    public String getPassword () {
        return password;
    }

    public String getInfo () {
        return "Employee Details:\n " +
                "Name: " + firstname + " " + lastname + "\n" +
                "Email: " + email + "\n" +
                "Password: " + password + "\n" +
                "Mailbox Capacity: " + mailboxCapacity;
    }
}

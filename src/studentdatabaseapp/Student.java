package studentdatabaseapp;

import java.awt.*;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String firstname;
    private String lastname;
    private int gradeYear;
    private String courses = "";
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor - prompt user to enter name and year
    public Student () {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter firstname: ");
        this.firstname = in.nextLine();

        System.out.print("Enter lastname: ");
        this.lastname = in.nextLine();

        System.out.print("Class Level: 1 - Fresher\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentId();
    }

    // Generate an Id
    private void setStudentId () {
        // studentId = gradeYear + id
        id++;
        this.studentId = gradeYear + id;
    }

    // Enroll in courses
    public void enrollCourse () {
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter course (Q to quit): ");
            String course = in.nextLine();

            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                System.out.println("BREAK!");
                break;
            }
        } while (1 != 0);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your Balance is $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition (int payment) {
        viewBalance();
        tuitionBalance -= payment;
        System.out.println("Thank you for you payment $" + payment);
        viewBalance();
    }

    // Show status
    public String showInfo () {
        return "\nStudent Details\n" +
                "\nStudentId: " + studentId +
                "\nName: " + firstname + " " + lastname +
                "\nYear: " + gradeYear +
                "\nENROLLED IN: " + courses +
                "\nTuition Balance: " + tuitionBalance;
    }
}

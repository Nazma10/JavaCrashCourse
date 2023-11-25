package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main (String args[]) {
        // Ask for no of new students
        System.out.print("Enter no of students: ");
        Scanner in = new Scanner(System.in);
        int noOfStudents = in.nextInt();
        Student[] students = new Student[noOfStudents];

        // Create no of new students
        for (int i=0; i<noOfStudents; i++) {
            students[i] = new Student();
            students[i].enrollCourse();
            students[i].payTuition(1000);
        }

        for (int i=0; i<noOfStudents; i++) {
            System.out.println(students[i].showInfo());
        }
    }
}

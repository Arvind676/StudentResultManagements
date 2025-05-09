
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks = new int[3];
    int total;
    double average;
    char grade;

    void calculateResults() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = total / 3.0;
        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 40) grade = 'D';
        else grade = 'F';
    }

    void displayResult() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Result Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    Student s = new Student();
                    System.out.print("Enter name: ");
                    s.name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    s.rollNo = sc.nextInt();
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        s.marks[i] = sc.nextInt();
                    }
                    s.calculateResults();
                    students.add(s);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    for (Student st : students) {
                        st.displayResult();
                        System.out.println("-------------------------");
                    }
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

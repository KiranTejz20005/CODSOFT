import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student implements Serializable {
    
	
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getRollNumber() == student.getRollNumber()) {
                System.out.println("Student with roll number " + student.getRollNumber() + " already exists!");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully");
    }

    public void removeStudent(int rollNumber) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student data saved to file");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No existing data file found. Starting with an empty list.");
            return;
        }
    
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        String filename = "students.dat";

        system.loadFromFile(filename);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Save and exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //sometimes after using nextInt it will stop the execution so we use nextline to clear it

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Name and grade cannot be empty");
                    } else {
                        Student student = new Student(name, rollNumber, grade);
                        system.addStudent(student);
                    }
                    break;

                case 2:
                    System.out.print("Enter roll number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    system.removeStudent(rollToRemove);
                    break;

                case 3:
                    System.out.print("Enter roll number of the student to search: ");
                    int rollToSearch = scanner.nextInt();
                    system.searchStudent(rollToSearch);
                    break;

                case 4:
                    system.displayAllStudents();
                    break;

                case 5:
                    system.saveToFile(filename);
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice ,Please try again.");
            }
        }
    }
}
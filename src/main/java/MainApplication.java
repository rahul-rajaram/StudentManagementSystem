import com.dev.model.Student;
import com.dev.service.StudentService;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        Scanner sc = new Scanner(System.in);

        boolean bRun = true;
        while (bRun) {
            displayMenu();
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addStudent(sc, studentService);
                    break;

                case 2:
                    updateStudent(sc, studentService);
                    break;

                case 3:
                    deleteStudent(sc, studentService);
                    break;

                case 4:
                    studentService.viewStudent();
                    break;

                case 5:
                    bRun = false;
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    public static void displayMenu() {

        System.out.println();
        System.out.println(
                "---------- STUDENT MANAGEMENT SYSTEM ----------"
        );

        System.out.println("1. Add Student data");
        System.out.println("2. Update Student data");
        System.out.println("3. Delete Student data");
        System.out.println("4. Display All Student data");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
    }

    private static void addStudent(
            Scanner sc,
            StudentService studentService) {

        System.out.println();
        System.out.println("---------- ADD STUDENT ----------");

        System.out.print("Enter Registration Number: ");
        int regNo = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.println();
        System.out.println("Select student details:");

        System.out.println("1. Basic details");
        System.out.println("2. Contact details");
        System.out.println("3. Complete details");

        System.out.print("Enter choice: ");

        int choice = Integer.parseInt(sc.nextLine());

        Student student;

        switch (choice) {

            case 1:

                student = new Student(
                        regNo,
                        name,
                        department
                );

                break;

            case 2:

                System.out.print("Enter Residential Status: ");
                String residentialStatus = sc.nextLine();

                System.out.print("Enter Email ID: ");
                String emailId = sc.nextLine();

                System.out.print("Enter Phone Number: ");
                String phoneNo = sc.nextLine();

                student = new Student(
                        regNo,
                        name,
                        department,
                        residentialStatus,
                        emailId,
                        phoneNo
                );

                break;

            case 3:

                System.out.print("Enter Residential Status: ");
                residentialStatus = sc.nextLine();

                System.out.print("Enter Email ID: ");
                emailId = sc.nextLine();

                System.out.print("Enter Phone Number: ");
                phoneNo = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                System.out.print("Enter Year of Birth: ");
                int dateOfBirth =
                        Integer.parseInt(sc.nextLine());

                student = new Student(
                        regNo,
                        name,
                        department,
                        residentialStatus,
                        emailId,
                        phoneNo,
                        address,
                        dateOfBirth
                );

                break;

            default:

                System.out.println("Invalid choice.");
                return;
        }

        System.out.println(
                studentService.addStudent(student)
        );
    }

    private static void updateStudent(
            Scanner sc,
            StudentService studentService) {

        System.out.println();
        System.out.println("---------- UPDATE STUDENT ----------");

        System.out.print("Enter Registration Number: ");

        int regNo = Integer.parseInt(sc.nextLine());

        Student existingStudent =
                studentService.findStudentById(regNo);

        if (existingStudent == null) {

            System.out.println("Student not found.");
            return;
        }

        System.out.print(
                "Enter New Name: "
        );
        String name = sc.nextLine();

        System.out.print(
                "Enter New Department: "
        );
        String department = sc.nextLine();

        System.out.print(
                "Enter Residential Status: "
        );
        String residentialStatus = sc.nextLine();

        System.out.print(
                "Enter Email ID: "
        );
        String emailId = sc.nextLine();

        System.out.print(
                "Enter Phone Number: "
        );
        String phoneNo = sc.nextLine();

        System.out.print(
                "Enter Address: "
        );
        String address = sc.nextLine();

        System.out.print(
                "Enter Year of Birth: "
        );
        int dateOfBirth =
                Integer.parseInt(sc.nextLine());

        Student updatedStudent = new Student(
                regNo,
                name,
                department,
                residentialStatus,
                emailId,
                phoneNo,
                address,
                dateOfBirth
        );

        System.out.println(
                studentService.updateStudent(updatedStudent)
        );
    }

    private static void deleteStudent(
            Scanner sc,
            StudentService studentService) {

        System.out.println();
        System.out.println("---------- DELETE STUDENT ----------");

        System.out.print(
                "Enter Registration Number: "
        );

        int regNo = Integer.parseInt(sc.nextLine());

        System.out.println(
                studentService.deleteStudentByID(regNo)
        );
    }
}

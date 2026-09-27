package com.dev.service;

import com.dev.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final String FILE_PATH =
            "E:\\FSD\\Mini Project\\StudentManagementSystem\\Student.txt";

    private List<Student> studentData;

    public StudentService() {
        studentData = loadFileData();
    }

    private List<Student> loadFileData() {

        List<Student> studentList = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("Student file not found.");
            return studentList;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] split = line.split(",", -1);

                try {

                    if (split.length == 3) {

                        studentList.add(
                                new Student(
                                        Integer.parseInt(split[0]),
                                        split[1],
                                        split[2]
                                )
                        );

                    } else if (split.length == 6) {

                        studentList.add(
                                new Student(
                                        Integer.parseInt(split[0]),
                                        split[1],
                                        split[2],
                                        split[3],
                                        split[4],
                                        split[5]
                                )
                        );

                    } else if (split.length == 8) {

                        studentList.add(
                                new Student(
                                        Integer.parseInt(split[0]),
                                        split[1],
                                        split[2],
                                        split[3],
                                        split[4],
                                        split[5],
                                        split[6],
                                        Integer.parseInt(split[7])
                                )
                        );

                    } else {

                        System.out.println(
                                "Invalid student data: " + line
                        );
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Invalid registration number/DOB: " + line
                    );
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
        }

        return studentList;
    }

    public String addStudent(Student student) {

        // Check duplicate registration number
        for (Student existingStudent : studentData) {

            if (existingStudent.getRegNo() == student.getRegNo()) {
                return "Student with this Registration Number already exists.";
            }
        }

        studentData.add(student);

        saveToFile();

        return "Student added successfully.";
    }

    public String updateStudent(Student updatedStudent) {

        for (int i = 0; i < studentData.size(); i++) {

            Student existingStudent = studentData.get(i);

            if (existingStudent.getRegNo() ==
                    updatedStudent.getRegNo()) {

                studentData.set(i, updatedStudent);

                saveToFile();

                return "Student updated successfully.";
            }
        }

        return "Student not found.";
    }

    public String deleteStudentByID(int id) {

        for (int i = 0; i < studentData.size(); i++) {

            if (studentData.get(i).getRegNo() == id) {

                studentData.remove(i);

                saveToFile();

                return "Student deleted successfully.";
            }
        }

        return "Student not found.";
    }

    public void viewStudent() {

        if (studentData.isEmpty()) {

            System.out.println("No student records found.");
            return;
        }

        for (Student student : studentData) {

            System.out.println(student);
        }
    }

    public Student findStudentById(int id) {

        for (Student student : studentData) {

            if (student.getRegNo() == id) {
                return student;
            }
        }

        return null;
    }

    private void saveToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Student student : studentData) {

                writer.write(convertStudentToLine(student));
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error writing to file: " + e.getMessage()
            );
        }
    }

    private String convertStudentToLine(Student student) {

        if (student.getAddress() != null &&
                !student.getAddress().isEmpty()) {

            return student.getRegNo() + "," +
                    student.getName() + "," +
                    student.getDepartment() + "," +
                    student.getResidentialStatus() + "," +
                    student.getEmailId() + "," +
                    student.getPhoneNo() + "," +
                    student.getAddress() + "," +
                    student.getDateOfBirth();

        } else if (student.getResidentialStatus() != null &&
                !student.getResidentialStatus().isEmpty()) {

            return student.getRegNo() + "," +
                    student.getName() + "," +
                    student.getDepartment() + "," +
                    student.getResidentialStatus() + "," +
                    student.getEmailId() + "," +
                    student.getPhoneNo();

        } else {

            return student.getRegNo() + "," +
                    student.getName() + "," +
                    student.getDepartment();
        }
    }
}

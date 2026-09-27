package com.dev.model;

public class Student {
    private int regNo;
    private String name;
    private String department;
    private String residentialStatus;
    private String emailId;
    private String phoneNo;
    private String address;
    private int dateOfBirth;

    public Student(int regNo, String name, String department) {
        this.regNo = regNo;
        this.name = name;
        this.department = department;
    }

    public Student(int regNo, String name, String department, String residentialStatus, String emailId, String phoneNo) {
        this.regNo = regNo;
        this.name = name;
        this.department = department;
        this.residentialStatus = residentialStatus;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public Student(int regNo, String name, String department, String residentialStatus, String emailId, String phoneNo, String address, int dateOfBirth) {
        this.regNo = regNo;
        this.name = name;
        this.department = department;
        this.residentialStatus = residentialStatus;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", residentialStatus='" + residentialStatus + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
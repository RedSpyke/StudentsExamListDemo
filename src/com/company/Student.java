package com.company;

public class Student {

    private String studentName;
    private int studentNumber;
    private double examGrade;

    public Student(String studentName, int studentNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
    }


    public String getStudentName() {
        return studentName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getExamGrade(int studentNumber) {
        return examGrade;
    }

    public void setExamGrade(int studentNumber,double examGrade) {
        this.examGrade = examGrade;
    }

    public static void printStudentInformation (String studentName, int studentNumber, double examGrade){
        System.out.println("Student name: "+ studentName +" - student number: " + studentNumber + " - exam grade: " + examGrade);
    }
}

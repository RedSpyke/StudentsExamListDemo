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
    public void setExamGrade(double examGrade) {
        if((examGrade >= 0) && (examGrade <= 10)){
            this.examGrade = examGrade;
        }
        else {
            System.out.println("Invalid exam grade.");
        }
    }

}

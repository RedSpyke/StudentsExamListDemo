package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in).useLocale(Locale.US);
    private static ArrayList<Student> examList = new ArrayList<>();

    public static void main(String[] args) {
        boolean closeProgram = false;
        int choice;

        while (!closeProgram) {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printStudentList();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    addStudentGrade();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    clearStudentList();
                    break;
                case 7:
                    averageGradeExam();
                case 8:
                    printExamStats();

                case 9:
                    closeProgram = true;
                    break;
            }
        }
    }

    public static  void printInstructions(){
        System.out.println(" Press: ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the student list. ");
        System.out.println("\t 2 - To add a student.");
        System.out.println("\t 3 - To remove a student on the list.");
        System.out.println("\t 4 - To add a student grade.");
        System.out.println("\t 5 - To search for a student in the list.");
        System.out.println("\t 6 - Clear the current list.  ");
        System.out.println("\t 7 - Calculate the average grade for the exam. ");
        System.out.println("\t 8 - Print exam stats. ");
        System.out.println("\t 9 - Exit application. ");
    }
    public static void printStudentList(){
        System.out.println("## Students on the exam list ##");
        for (Student student : examList) {
            System.out.println("Student name: " + student.getStudentName() +
                    " Student number: " + student.getStudentNumber());
        }
    }
    public static void addStudent(){

        System.out.println("## Add student from exam list ##");
        System.out.print("Please insert name of student: " );
        String studentName = input.nextLine();
        System.out.print("Please insert student number: " );
        int studentNumber = input.nextInt();
        if(!searchStudent(studentNumber)) {
            examList.add(new Student(studentName, studentNumber));
        }
    }
    public static void removeStudent(){
        System.out.println("## Remove student from exam list ##");
        System.out.print("Please insert student number: ");
        int studentNumber = input.nextInt();
        if (searchStudent(studentNumber)){
            examList.remove(searchStudentIndex(studentNumber));
            System.out.println("Student has been removed from the list. ");
        }
        else {
            System.out.println("Student not on the list.");
        }
    }
    public static void addStudentGrade(){
        System.out.println("## Add student grade ##");
        System.out.print("Please insert student number: ");
        int studentNumber = input.nextInt();
        if (searchStudent(studentNumber)){
            System.out.print("Please insert student grade: ");
            double grade = input.nextDouble();
            if (grade >= 0 && grade <=10){
                examList.get(searchStudentIndex(studentNumber)).setExamGrade(grade);
                System.out.println("Grade added.");
            }
            else {
                System.out.println("Grade parameter invalid");
                System.out.println("Grade not added to the student");
            }
            // System.out.println(grade);
        }
        else {
            System.out.println("Student number is not valid.");
        }
    }

    public static void searchStudent(){
        System.out.print("Please insert student number: ");
        int studentNumber = input.nextInt();
        for (Student student : examList) {
            if (studentNumber == student.getStudentNumber()) {
                 System.out.println("Student on the list.");
            }
        }
    }
    public static boolean searchStudent(int studentNumber){

        for (Student student : examList) {
            if (studentNumber == student.getStudentNumber()) {
                // System.out.println("Student on the list.");
                return true;
            }
        }
        return false;
    }
    public static int searchStudentIndex(int studentNumber){
        for (int i = 0; i < examList.size() ; i++) {
            if (studentNumber == examList.get(i).getStudentNumber()){
                System.out.println("Student on the list.");
                return i;
            }
        }
        return -1;
    }

    public static void clearStudentList(){
        System.out.println("The current list has been cleared");
        examList.clear();
    }
    public static void averageGradeExam(){
        int numberOfGrades = 0;
        double examGrade;
        double examGradeSum = 0.0;
        double averageExamResult;
        for (Student student : examList) {
            examGrade = student.getExamGrade();
            if (examGrade != 0.0) {
                examGradeSum += examGrade;
                System.out.println(examGrade);
                numberOfGrades++;
            }
        }
        averageExamResult = examGradeSum / numberOfGrades;
        System.out.println(averageExamResult);
    }

    public static void printExamStats (){

    }

}
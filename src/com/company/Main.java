package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static ArrayList<Student> examList = new ArrayList<>();

    public static void main(String[] args) {
        boolean closeProgram = false;
        int choice = 0;

        while (!closeProgram) {
            System.out.println("Enter your choice: ");
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
        System.out.println("\t 2 - To add a student grade.");
        System.out.println("\t 3 - To remove a student on the list.");
        System.out.println("\t 4 - To change a student grade.");
        System.out.println("\t 5 - To search for a student in the list.");
        System.out.println("\t 6 - Clear the current list.  ");
        System.out.println("\t 7 - Calculate the average of grade for the exam. ");
        System.out.println("\t 8 - Print exam stats. ");
        System.out.println("\t 9 - Exit application. ");
    }
    public static void printStudentList(){
        int numberOfStudents = examList.size();
        for (int i = 0; i < numberOfStudents ; i++) {
            System.out.println("Student name: "+ examList.get(i).getStudentName()+
                    " Student number: "+ examList.get(i).getStudentNumber());
        }
    }
    public static void addStudent(){
        // TO DO: verify if student already on the list
        System.out.print("Please insert name of student: \n" );
        String studentName = input.nextLine();
        System.out.print("Please insert student number: \n" );
        int studentNumber = input.nextInt();
        examList.add(new Student(studentName,studentNumber));

    }
    public static void removeStudent(){

    }
    public static void addStudentGrade(){

    }
    public static void searchStudent(){

    }
    public static void clearStudentList(){

    }
    public static void averageGradeExam(){

    }
    public static void printExamStats (){

    }

}
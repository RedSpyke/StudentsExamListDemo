package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in).useLocale(Locale.US);
    private static ArrayList<Student> examList = new ArrayList<>();
    static double minimumGradeExam = 5.5;

    public static void main(String[] args) {
        boolean closeProgram = false;
        int choice;

        examList.add(new Student("Alex", 1234));
        examList.add(new Student("Bogdan", 2345));
        examList.add(new Student("Andrei", 3456));
        examList.add(new Student("Vlad", 4567));
        examList.add(new Student("Calin", 5678));
        examList.add(new Student("Matei", 6789));
        examList.get(searchStudentIndex(1234)).setExamGrade(4.5);
        examList.get(searchStudentIndex(2345)).setExamGrade(6.75);
        examList.get(searchStudentIndex(3456)).setExamGrade(7.3);
        examList.get(searchStudentIndex(4567)).setExamGrade(1.5);
        examList.get(searchStudentIndex(5678)).setExamGrade(9.75);
        examList.get(searchStudentIndex(6789)).setExamGrade(2.3);

        while (!closeProgram) {
            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()){
                System.out.println("Wrong input data!");
                input.next();
                System.out.println("Enter your choice: ");
            }
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
                    printExamStats();
                    break;
                case 8:
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
        System.out.println("\t 7 - Print exam stats. ");
        System.out.println("\t 8 - Exit application. ");
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
        System.out.print("Please insert student number: " );
        while (!input.hasNextInt()){
            System.out.println("Wrong input data!");
            input.next();
            System.out.println("Please insert student number: ");
        }
        int studentNumber = input.nextInt();
        if(!searchStudent(studentNumber)) {
            input.nextLine();
            System.out.print("Please insert name of student: " );
            String studentName = input.nextLine();
            examList.add(new Student(studentName, studentNumber));
            System.out.println("Student added to the list. ");
        }
        else{
            System.out.println("Student number already in use.");
        }
    }
    public static void removeStudent(){
        System.out.println("## Remove student from exam list ##");
        System.out.print("Please insert student number: ");
        while (!input.hasNextInt()){
            System.out.println("Wrong input data!");
            input.next();
            System.out.println("Please insert student number: ");
        }
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
        while (!input.hasNextInt()){
            System.out.println("Wrong input data!");
            input.next();
            System.out.println("Please insert student number: ");
        }
        int studentNumber = input.nextInt();

        if (searchStudent(studentNumber)){
            System.out.print("Please insert student grade: ");
            while (!input.hasNextDouble()){
                System.out.println("Wrong input data!");
                input.next();
                System.out.println("Please insert student grade: ");
            }
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
                // System.out.println("Student on the list.");
                return i;
            }
        }
        return -1;
    }

    public static void clearStudentList(){
        System.out.println("The current list has been cleared");
        examList.clear();
    }
    private static double averageGradeExam(){
        int numberOfGrades = 0;
        double examGrade;
        double examGradeSum = 0.0;
        double averageExamResult;
        for (Student student : examList) {
            examGrade = student.getExamGrade();
            if (examGrade != 0.0) {
                examGradeSum += examGrade;
                //System.out.println(examGrade);
                numberOfGrades++;
            }
        }
        averageExamResult = examGradeSum / numberOfGrades;
        //System.out.println(averageExamResult);
        return averageExamResult;
    }

    public static void printExamStats (){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        int zeroTwo = 0;
        int twoFour = 0;
        int fourSix = 0;
        int sixEight = 0;
        int eightTen = 0;
        double studentGrade;
        double highestGrade = 0;
        System.out.println("## Students present in the exam ##");
        for (int i = 0; i < examList.size(); i++) {
            studentGrade = examList.get(i).getExamGrade();
            System.out.println(i + " - Student name: " + examList.get(i).getStudentName() +
                    " Student number: " + examList.get(i).getStudentNumber() + " grade => "+ studentGrade);
            if (studentGrade > highestGrade){
                highestGrade = studentGrade;
            }
            if((studentGrade > 0)&&(studentGrade <= 2)){
                zeroTwo++;
            }
            if((studentGrade > 2)&&(studentGrade <= 4)){
                twoFour++;
            }
            if((studentGrade > 4)&&(studentGrade <= 6)){
                fourSix++;
            }
            if((studentGrade > 6)&&(studentGrade <= 8)){
                sixEight++;
            }
            if((studentGrade > 8)&&(studentGrade <= 10)){
                eightTen++;
            }
        }
        System.out.println("The highest grade is: "+ nf.format(highestGrade));
        System.out.println("The average grade is: " + nf.format(averageGradeExam()));
        System.out.println("Number of students that have passed the exam: " + NumberStudentsPass());
        System.out.println("Number of grades between 0 and 2 : " + zeroTwo);
        System.out.println("Number of grades between 2 and 4 : " + twoFour);
        System.out.println("Number of grades between 4 and 6 : " + fourSix);
        System.out.println("Number of grades between 6 and 8 : " + sixEight);
        System.out.println("Number of grades between 8 and 10: " + eightTen);
    }
    public static int NumberStudentsPass () {

        int studentsThatHavePassed = 0;
        for (Student student : examList) {
            double examGrade = student.getExamGrade();
            if (examGrade >= minimumGradeExam) {
                studentsThatHavePassed++;
            }
        }
        return studentsThatHavePassed;
    }
}
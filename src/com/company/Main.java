package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> examList = new ArrayList<>();

        boolean closeProgram = false;
        int choice = 0;
        printInstructions ();

        while (!closeProgram){
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 0:
                    printInstructions ();
                    break;
                case 1:
                    examList.printStudentList();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    changeStudentGrade();
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
                    printExamStats ();

                case 7:
                    closeProgram = true;
                    break;


            }



        }





    }
}

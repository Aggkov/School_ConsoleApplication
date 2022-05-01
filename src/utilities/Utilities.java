package utilities;

import SyntheticData.SyntheticPrivateSchool;
import models.PrivateSchool;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class Utilities {


    public static void Menu(int mode) {
        boolean quit = false;
        while (!quit) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n========================= MENU ===========================");


        System.out.println("\nAvailable actions:\nPress: \n");
        System.out.println("1  - Show all the students\n" +
                "2  - Show all the trainers\n" +
                "3  - Show all the assignments\n" +
                "4  - Show all the courses\n" +
                "5  - Show all Students per Course\n" +
                "6  - Show all Trainers per Course\n" +
                "7 -  Show all the assignments per Course\n" +
                "8  - Show all the assignments per Student\n" +
                "9  - Show Students that belong to more than one course" + "\n" +
                "10  - Type a Date to show a list of students who need to submit one or " +
                "more assignments on the same calendar week" + "\n" +
                "11  - Type 11 to quit the application");

            System.out.println("====================================================");

            System.out.print("Choose your action: ");

            int action = integerInput();

            switch (action) {
                case 1:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllStudents();
                    else
                        PrivateSchool.showAllStudents();
                    break;

                case 2:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllTrainers();
                    else
                        PrivateSchool.showAllTrainers();
                    break;

                case 3:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllAssignments();
                    else
                        PrivateSchool.showAllAssignments();
                    break;

                case 4:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllCourses();
                    else
                        PrivateSchool.showAllCourses();
                    break;

                case 5:

                    if (mode == 2)
                        SyntheticPrivateSchool.showAllStudentsPerCourse();
                    else
                        PrivateSchool.showAllStudentsPerCourse();
                    break;

                case 6:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllTrainersPerCourse();
                    else
                        PrivateSchool.showAllTrainersPerCourse();
                    break;

                case 7:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllAssignmentsPerCourse();
                    else
                        PrivateSchool.showAllAssignmentsPerCourse();
                    break;

                case 8:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllAssignmentsPerStudent();
                    else
                        PrivateSchool.showAllAssignmentsPerStudent();
                    break;

                case 9:
                    if (mode == 2)
                        SyntheticPrivateSchool.showAllStudentsSignedUpInMoreThanOneCourse();
                    else
                        PrivateSchool.showAllStudentsSignedUpInMoreThanOneCourse();
                    break;

                case 10:
                    if (mode == 2)
                        SyntheticPrivateSchool.dateQuery();
                    else
                        PrivateSchool.dateQuery();
                    break;

                case 11:
                    System.out.println("Quiting application ....");
                    quit = true;
            }
        }
    }

    public static int integerInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.print("Please type an integer: ");
                sc.next();
            } else {
                break;
            }
        }
        int num = sc.nextInt();
        return num;
    }

    public static LocalDate dateInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please type a date for Assignment submission (dd-MM-yyyy): ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String Date;
        LocalDate formattedDate;
        while (true) {
            if (!sc.hasNextLine()) {
                System.out.println("Please insert date in valid format! (dd-MM-yyyy)");
            } else {
                try {
                    Date = sc.nextLine();
                    formattedDate = LocalDate.parse(Date, formatter);
                    break;

                } catch (DateTimeParseException e) {
                    System.out.println("Please insert date in valid format! (dd-MM-yyyy)");
                }
            }

        }
        return formattedDate;
    }
}









package utilities;

import functions.Functions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class Utilities {

    // Singleton
    private static Utilities utils_instance =  null;

    private Utilities() {

    }

    public static Utilities getUtilitiesInstance() {
        if(utils_instance == null)  {
            utils_instance = new Utilities();
        }
        return utils_instance;
    }

    public void Menu() {

        Functions functions_instance = Functions.getFunctionsInstance();

        boolean quit = false;
        while (!quit) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================= MENU ===========================");


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
                    functions_instance.showAllStudents();
                    break;

                case 2:
                    functions_instance.showAllTrainers();
                    break;

                case 3:
                    functions_instance.showAllAssignments();
                    break;

                case 4:
                    functions_instance.showAllCourses();
                    break;

                case 5:
                    functions_instance.showAllStudentsPerCourse();
                    break;

                case 6:
                    functions_instance.showAllTrainersPerCourse();
                    break;

                case 7:
                    functions_instance.showAllAssignmentsPerCourse();
                    break;

                case 8:
                    functions_instance.showAllAssignmentsPerStudent();
                    break;

                case 9:
                    functions_instance.showAllStudentsSignedUpInMoreThanOneCourse();
                    break;

                case 10:
                    functions_instance.dateQuery();
                    break;

                case 11:
                    System.out.println("Quiting application ....");
                    quit = true;
            }
        }
    }

    public int integerInput() {
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

    public LocalDate dateInput() {
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









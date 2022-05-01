package models;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class Assignment {
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;

    public Assignment() {
        readAssignment(new Scanner(System.in));
    }

    public Assignment(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }
    // User Input for Assignments
    public void readAssignment(Scanner sc) {
        System.out.println("------------------------------------");
        System.out.print("Please enter the assignment's title: ");
        this.title = sc.nextLine();
        System.out.print("Please enter the assignment's description: ");
        this.description = sc.nextLine();

        System.out.print("Please enter the submission date of the assignment: ");
        String subDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while(true) {
            try {
                subDate = sc.nextLine().trim();
                this.subDateTime = LocalDate.parse(subDate, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.print("Please insert date in valid format! (dd-MM-yyyy)");

            }
        }
        do {
            System.out.print("Please enter " + title + "'s oral mark (up to 40): ");
            while(!sc.hasNextInt()) {
                System.out.print("Please type an integer: ");
                sc.next();
            }
            this.oralMark = sc.nextInt();

        } while(oralMark > 40);

        do {
            System.out.print("Please enter " + title + "'s total mark (up to 100): ");
            while(!sc.hasNextInt()) {
                System.out.print("Please type an integer: ");
                sc.next();
            }
            this.totalMark = sc.nextInt();

        } while(totalMark > 100);
    }

    public void showAssignmentDetails() {
        System.out.println("[" + this.title.toUpperCase() + " ---> " + this.description.toUpperCase() + " | " + "Submission Date: " +  this.subDateTime + " | " + "Oral Mark: " + this.oralMark + " | " + "Total Mark: " + this.totalMark + " ] " + "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Assignment that = (Assignment) obj;
        return oralMark == that.oralMark && totalMark == that.totalMark && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(subDateTime, that.subDateTime);
    }


    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    @Override
    public String toString() {
        return ("[" + title.toUpperCase() +
                " ---> "
                + description.toUpperCase()
                + " | " + "Submission Date: " +  subDateTime + " | "
                + "Oral Mark: " + oralMark + " | "
                + "Total Mark: " + totalMark + " ] ");
    }
}
















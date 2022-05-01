package models;

import java.util.Scanner;

public class Trainer implements Comparable<Trainer>{
    private String firstName;
    private String lastName;
    private String subject;


    public Trainer() {
        readTrainer(new Scanner(System.in));

    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public void readTrainer(Scanner sc) {
        System.out.print("Type trainer's firstname: ");

        this.firstName = sc.nextLine().trim();
        System.out.print("Type trainer's lastname: ");
        this.lastName = sc.nextLine().trim();
        System.out.print("Type his subject : ");
        this.subject = sc.nextLine().trim();

    }

    public void showTrainerDetails() {
        System.out.print(firstName.toUpperCase() + " " + lastName.toUpperCase() + " " + "|" + "Subject: " + subject.toUpperCase() + "\n");
    }


    @Override
    public int compareTo(Trainer other) {
        return this.lastName.compareTo(other.lastName);

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "firstName='" + firstName.toUpperCase() + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}

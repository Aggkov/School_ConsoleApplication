package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Course  {

    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    private Set<Trainer> trainers = new TreeSet<>();
    public  Set<Student> students = new TreeSet<>();
    public static List<Assignment> assignments = new ArrayList<>();

    final static int numOfTrainers = 8;
    final static int numOfStudents = 20;


    public Course()  {

        readCourse(new Scanner(System.in));

        System.out.print("Please Insert data for 8 trainers : ");
        for(int i = 0; i < numOfTrainers; i++) {
            Trainer trainer = new Trainer();
            // add trainer to course structure

            this.trainers.add(trainer);
            // add trainer to Master Set of Trainers
            PrivateSchool.allTrainers.add(trainer);
        }

        System.out.print("Please insert data for 20 Students : ");

        for(int i = 0; i < numOfStudents; i++) {
            Student student = new models.Student();
            this.students.add(student);

            PrivateSchool.allStudents.add(student);
        }
    }

    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
        trainers = new TreeSet<>();
        students = new TreeSet<>();
    }

    public void readCourse (Scanner sc)  {

        System.out.print("\n\nPlease enter course's title: ");

        this.title = sc.nextLine();
        System.out.print("Please enter course's stream: ");
        this.stream = sc.nextLine();
        System.out.print("Please enter type of the course (Full-time or Part-time): ");
        this.type = sc.nextLine();
        String startDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Please enter the start date of the course: ");
        while (true) {
            try {
                startDate = sc.next().trim();
                this.start_date = LocalDate.parse(startDate, formatter);
                break;

            } catch (DateTimeParseException ex) {
                System.out.print("Please insert date in valid format! (dd-MM-yyyy): ");
            }
        }

        System.out.print("Please enter the end date of the course: ");
        String endDate;
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean flag = false;
        while (!flag) {
            try {
                endDate = sc.next().trim();
                this.end_date = LocalDate.parse(endDate, formatter);
                while (this.end_date.isBefore(this.start_date)) {
                    System.out.println("End date can't be before Start date! Please enter a valid date!");
                    endDate = sc.next();
                    this.end_date = LocalDate.parse(endDate, formatter);
                }

                flag = true;

            } catch (DateTimeParseException e) {
                System.out.println("Please insert date in valid format! (dd-MM-yyyy)");
            }

            System.out.println();
        }
    }

    public boolean addNewStudent(models.Student student) {
        if(!students.add(student)) {
            return false;
        }
        return true;
    }

    public boolean addNewTrainer(Trainer trainer) {
        if(!trainers.add(trainer)) {
            return false;
        }
        return true;
    }

    public boolean addNewAssignment(Assignment assignment) {
        if(findAssignment(assignment) < 0) {
            assignments.add(assignment);
            return true;
        }
        else {
            return false;
        }
    }

    private int findAssignment(Assignment assignment) {
        return assignments.indexOf(assignment);
    }

    public void showCourseDetails() {
        System.out.println("==================================================================");
        System.out.print("Course {" + title.toUpperCase() + "|" + stream.toUpperCase() + "|" + type.toUpperCase() + "|"
                + start_date + "|" + end_date + "|}" + "\n");
    }

    public void printListOfStudents() {
        for(Student student : this.students) {
            student.showStudentDetails();
        }
    }

    public void printListOfTrainers() {
        for(Trainer trainer: this.trainers) {
            trainer.showTrainerDetails();
        }
    }

    // For each assignment in Course class
    public void printListOfAssignments() {
        System.out.println("Assignments for course: " + getTitle());
        System.out.println("----------");
        for(Assignment assignment: assignments) {
            assignment.showAssignmentDetails();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(title, course.title) && Objects.equals(stream, course.stream) && Objects.equals(type, course.type) && Objects.equals(start_date, course.start_date) && Objects.equals(end_date, course.end_date) && Objects.equals(trainers, course.trainers) && Objects.equals(students, course.students) && Objects.equals(assignments, course.assignments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, stream, type, start_date, end_date, trainers, students, assignments);
    }

    public String getTitle() {
        return title;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    @Override
    public String toString() {
        return
                " title ='" + this.title.toUpperCase() + '\'' +
                ", type ='" + this.type.toUpperCase() + '\'' +
                ", start_date ='" + this.start_date + '\'' +
                ", end_date ='" + this.end_date + '\n' +
                " TrainersList = " + this.trainers +  '\n' +
                " StudentsList =" + this.students +  '\n' +
                '}';
    }
}

package models;

import utilities.Utilities;
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


    public Course()  {

        readCourse(new Scanner(System.in));

        System.out.print("How many trainers would you like to add to this course? : ");
        int numOfTrainers = Utilities.integerInput();
        for(int i = 0; i < numOfTrainers; i++) {
            Trainer trainer = new models.Trainer();
            this.trainers.add(trainer);

            PrivateSchool.allTrainers.add(trainer);
        }

        System.out.print("How many Students would you like to add to this course? : ");
        int numOfStudents = Utilities.integerInput();

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

        System.out.println("-----------------------------");
        System.out.print("Please enter course's title: ");

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
        for(Assignment assignment: this.assignments) {
            assignment.showAssignmentDetails();
        }
    }

    public boolean addNewTrainer(Trainer trainer) {
        if(!trainers.add(trainer)) {
            return false;
        }
        return true;
    }

    public boolean addNewAssignment(Assignment assignment) {
        if(findAssignment(assignment) < 0) {
            this.assignments.add(assignment);
            return true;
        }
        else {
            return false;
        }
    }

    private int findAssignment(Assignment assignment) {
        return this.assignments.indexOf(assignment);
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
    public String getStream() {
        return stream;
    }
    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public TreeSet<Trainer> getTrainers() {
        return (TreeSet<Trainer>) trainers;
    }

    public void setTrainers(TreeSet<Trainer> trainers) {
        this.trainers = trainers;
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

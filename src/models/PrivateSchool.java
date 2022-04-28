package models;

import utilities.Utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;


public class PrivateSchool {
    private String name;
    public static List<models.Course> allCourses = new ArrayList<>();  // Master List for Courses
    public static Set<models.Trainer> allTrainers = new TreeSet<>();   // Master List for Trainers
    public static Set<models.Student> allStudents = new TreeSet<>();   // Master List for Students
    public static List<models.Assignment> allAssignments = new ArrayList<>();  // Master List for Assignments

    public PrivateSchool(String name)  {
        this.name = name;
        System.out.print("How many courses would you like to add? : ");
        int numOfCourses = Utilities.integerInput();

        for(int i = 0; i < numOfCourses; i++) {
            allCourses.add(new models.Course());
        }
    }

    public static void showAllCourses() {
        System.out.println("All Courses: ");
        for(models.Course c: allCourses) {
            c.showCourseDetails();
        }
        System.out.println("-----------------");
    }

    public static void showAllTrainers() {
        System.out.println("All Trainers: ");
        System.out.println("-----------------");
        for(models.Trainer trainer: allTrainers) {
            trainer.showTrainerDetails();
        }
        System.out.println("-----------------");
    }

    public static void showAllStudents() {
        System.out.println("All Students: ");
        System.out.println("------------------------");
        for(models.Student student: allStudents) {
            student.showStudentDetails();
        }
        System.out.println("------------------------");
    }

    public static void showAllAssignments() {
        System.out.println("All Assignments: ");
        System.out.println("------------------------");
        for(models.Assignment assignment: allAssignments) {
            assignment.showAssignmentDetails();
        }
        System.out.println("------------------------");
    }


    public static void showAllStudentsPerCourse() {
        System.out.println();
        for(int i = 0; i < allCourses.size(); i++) {
            allCourses.get(i).showCourseDetails();
            allCourses.get(i).printListOfStudents();
        }
    }

    public static void showAllTrainersPerCourse() {
        System.out.println();
        for(int i = 0; i < allCourses.size(); i++) {
            allCourses.get(i).showCourseDetails();
            allCourses.get(i).printListOfTrainers();
        }
    }

    public static void showAllAssignmentsPerCourse() {
        System.out.println();
        for(int i = 0; i < allCourses.size(); i++) {
            allCourses.get(i).showCourseDetails();
            allCourses.get(i).printListOfAssignments();
        }
    }

    public static void showAllAssignmentsPerStudent() {
        List<models.Student> allStudentsList = new ArrayList<>(allStudents);
        System.out.println();
        for(int i = 0; i < allStudents.size(); i++) {
            allStudentsList.get(i).showStudentDetails();
            allStudentsList.get(i).showListOfAssignments();
        }
    }

    public static void showAllStudentsSignedUpInMoreThanOneCourse() {
        List<models.Student> studentsList = allCourses.stream()
                .flatMap(course -> course.getStudents().stream()).toList();

        Set<models.Student> studentsInMoreThanOneCourse = new TreeSet<>();
        for(int i = 0; i < studentsList.size(); i++) {
            if(Collections.frequency(studentsList, studentsList.get(i)) > 1) {
                studentsInMoreThanOneCourse.add(studentsList.get(i));
            }
        }

        for(models.Student student: studentsInMoreThanOneCourse) {
            System.out.println(student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase());
        }
    }

    public static void dateQuery() {
        LocalDate dateToQuery = Utilities.dateInput();

        DayOfWeek searchDay = dateToQuery.getDayOfWeek();
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now();

        switch(searchDay.toString()){
            case "MONDAY":
                start = dateToQuery.minusDays(1);
                end = dateToQuery.plusDays(7);
                break;
            case "TUESDAY":
                start = dateToQuery.minusDays(2);
                end = dateToQuery.plusDays(6);
                break;
            case "WEDNESDAY":
                start = dateToQuery.minusDays(3);
                end = dateToQuery.plusDays(5);
                break;
            case "THURSDAY":
                start = dateToQuery.minusDays(4);
                end = dateToQuery.plusDays(4);
                break;
            case "FRIDAY":
                start = dateToQuery.minusDays(5);
                end = dateToQuery.plusDays(3);
                break;
            case "SATURDAY":
                start = dateToQuery.minusDays(6);
                end = dateToQuery.plusDays(2);
                break;
            case "SUNDAY":
                start = dateToQuery.minusDays(7);
                end = dateToQuery.plusDays(1);
                break;
        }

        for(models.Student student: allStudents) {
            if(student.hasAssignment(start, end)) {
                System.out.println("\nStudent " + student.getFirstName() + " " + student.getLastName() + " " + "has these assignments due: \n");
                student.showListOfAssignmentsDue(start, end);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<models.Course> getCourses() {
        return allCourses;
    }

    public static Set<models.Trainer> getAllTrainers() {
        return allTrainers;
    }

    public static Set<models.Student> getAllStudents() {
        return allStudents;
    }

    public static List<models.Assignment> getAllAssignments() {
        return allAssignments;
    }

    @Override
    public String toString() {
        return "=============================" + '\n' +
                "PrivateSchool " +
                "Name = " + name + '\n' + '\n' +
                '}';
    }
}

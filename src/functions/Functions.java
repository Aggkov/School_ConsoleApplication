package functions;

import data.Data;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;
import utilities.Utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Functions {

    // Singleton
    private static Functions functions_instance =  null;

    private Functions() {

    }

    public static Functions getFunctionsInstance() {
        if(functions_instance == null)  {
            functions_instance = new Functions();
        }
        return functions_instance;
    }

    Data data_instance = Data.getData_instance();

    // Get Data Structures from Data Class
    List<Course> allCourses = data_instance.allCourses;
    Set<Student> allStudents = data_instance.allStudents;
    Set<Trainer> allTrainers = data_instance.allTrainers;
    List<Assignment> allAssignments = data_instance.allAssignments;

    public void showAllCourses() {
        System.out.println("All Courses: ");
        for(Course course: allCourses) {
            course.showCourseDetails();
        }
        System.out.println("-----------------");
    }

    public void showAllTrainers() {
        System.out.println("All Trainers: ");
        System.out.println("-----------------");
        for(Trainer trainer: allTrainers) {
            trainer.showTrainerDetails();
        }
        System.out.println("-----------------");
    }

    public void showAllStudents() {
        System.out.println("All Students: ");
        System.out.println("------------------------");
        for(Student student: allStudents) {
            student.showStudentDetails();
        }
        System.out.println("------------------------");
    }

    public void showAllAssignments() {
        System.out.println("All Assignments: ");
        System.out.println("------------------------");
        for(Assignment assignment: allAssignments) {
            assignment.showAssignmentDetails();
        }
        System.out.println("------------------------");
    }


    public void showAllStudentsPerCourse() {
        System.out.println();
        for(int i = 0; i < allCourses.size(); i++) {
            allCourses.get(i).showCourseDetails();
            allCourses.get(i).printListOfStudents();
        }
    }

    public void showAllTrainersPerCourse() {
        System.out.println();
        for(int i = 0; i < allCourses.size(); i++) {
            allCourses.get(i).showCourseDetails();
            allCourses.get(i).printListOfTrainers();
        }
    }

    public void showAllAssignmentsPerCourse() {
        System.out.println();
        for(int i = 0; i < allCourses.size(); i++) {
            allCourses.get(i).showCourseDetails();
            allCourses.get(i).printListOfAssignments();
        }
    }

    public void showAllAssignmentsPerStudent() {
        List<Student> allStudentsList = new ArrayList<>(allStudents);
        System.out.println();
        for(int i = 0; i < allStudents.size(); i++) {
            allStudentsList.get(i).showStudentDetails();
            allStudentsList.get(i).showListOfAssignments();
        }
    }

    public void showAllStudentsSignedUpInMoreThanOneCourse() {
        // Map all Students in one List
        List<Student> studentsList = allCourses.stream()
                .flatMap(course -> course.getStudents().stream()).toList();

        // Create new TreeSet to store non-duplicate Student entities
        Set<Student> studentsInMoreThanOneCourse = new TreeSet<>();
        for(int i = 0; i < studentsList.size(); i++) {
            if(Collections.frequency(studentsList, studentsList.get(i)) > 1) {
                studentsInMoreThanOneCourse.add(studentsList.get(i));
            }
        }

        System.out.println("Students Enrolled in more than one Course: \n");
        for(Student student: studentsInMoreThanOneCourse) {
            System.out.println(student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase());
        }
    }

    public void dateQuery() {
        Utilities instance = Utilities.getUtilitiesInstance();
        LocalDate dateToQuery = instance.dateInput();

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

        for(Student student: allStudents) {
            if(student.hasAssignmentDue (start, end)) {
                System.out.println("\nStudent " + student.getFirstName() + " " + student.getLastName() + " " + "has these assignments due: \n");
                student.showListOfAssignmentsDue(start, end);
            }
        }
    }
}

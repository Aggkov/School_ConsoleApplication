package data;

import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Data {

    // Singleton
    private static Data data_instance =  null;

    public  List<Course> allCourses = new ArrayList<>();  // Master List for Courses
    public  Set<Trainer> allTrainers = new TreeSet<>();   // Master Set for Trainers -- All Unique trainers sorted in ascending order
    public  Set<Student> allStudents = new TreeSet<>();   // Master Set for Students --- All Unique students sorted in ascending order
    public  List<Assignment> allAssignments = new ArrayList<>();  // Master List for Assignments

    private Data() {

    }

    public static Data getData_instance() {
        if(data_instance == null)  {
            data_instance = new Data();
        }
        return data_instance;
    }
}

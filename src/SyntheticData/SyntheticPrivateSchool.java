package SyntheticData;

import data.Data;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

import java.time.LocalDate;
import java.util.*;

public class SyntheticPrivateSchool {

    private String name;

    Data data_instance = Data.getData_instance();

    public SyntheticPrivateSchool() {
        this.name = "Synthetic School";

        // Synthetic Trainers
        Trainer trainer1 = new Trainer("John", "Johnson", "Java");
        Trainer trainer2 = new Trainer("Nick", "Williams", "Java");
        Trainer trainer3 = new Trainer("Jack", "Jackson", "javaScript");
        Trainer trainer4 = new Trainer("Caren", "Lizette", "JavaScript");
        Trainer trainer5 = new Trainer("Kate", "Webster", "C");
        Trainer trainer6 = new Trainer("Phil", "Philson", "C");
//        allTrainers = new TreeSet<>();
        Collections.addAll(data_instance.allTrainers, trainer1, trainer2, trainer3, trainer4, trainer5, trainer6);

        // Synthetic Students
        Student MIKE_WILLIAMS = new Student("Mike", "Williams", 500, LocalDate.of(1985,05,20));
        Student LUVENIA_CHARLES = new Student("Luvenia", "Charles", 500, LocalDate.of(1988,05,20));
        Student JOHN_TRAVOLTA = new Student("john", "Travolta", 500, LocalDate.of(1994,05,20));
        Student MARY_TYLER = new Student("Mary", "Tyler", 500, LocalDate.of(1985,05,20));
        Student HELEN_ROSE = new Student("Helen", "Rose", 500, LocalDate.of(1995,05,20));
        Student CHRIS_ROBINSON = new Student("Chris", "Robinson", 500, LocalDate.of(1990,05,20));
        Student DOLPH_MOE = new Student("Dolph", "Moe", 500, LocalDate.of(1990,05,20));
        Student JACK_ARTIE = new Student("Jack", "Artie", 500, LocalDate.of(1980,05,20));
        Student TYE_GERALD = new Student("Tye", "Gerald", 500, LocalDate.of(1986,05,20));
        Student ANDERSON_ABE = new Student("Anderson", "Abe", 500, LocalDate.of(1991,05,20));
        Student WILLIAM_EARNEST = new Student("William", "Earnest", 500, LocalDate.of(1991,05,20));
        Student NICOLAS_WEBSTER = new Student("Nicolas", "Webster", 500, LocalDate.of(1991,05,20));
        Student CAITLYN_MERYL = new Student("Caitlyn", "Meryl", 500, LocalDate.of(1991,05,20));
        Collections.addAll(data_instance.allStudents, MIKE_WILLIAMS, LUVENIA_CHARLES, JOHN_TRAVOLTA, MARY_TYLER, HELEN_ROSE, CHRIS_ROBINSON, DOLPH_MOE, JACK_ARTIE, TYE_GERALD, ANDERSON_ABE, WILLIAM_EARNEST, NICOLAS_WEBSTER, CAITLYN_MERYL);

        // Synthetic Courses
        Course JAVA = new Course("JAVA","java", "part time", LocalDate.of(2022,3,10), LocalDate.of(2022,07,30));
        Course C_Programming = new Course("C programming","C", "part time", LocalDate.of(2022,3,10), LocalDate.of(2022,07,30));
        Course JAVASCRIPT = new Course("JAVASCRIPT","Javascript", "part time", LocalDate.of(2022,3,10), LocalDate.of(2020,07,30));
//        allCourses = new ArrayList<>();
        Collections.addAll(data_instance.allCourses, JAVA, C_Programming, JAVASCRIPT);

        // Assignments for course C
        Assignment C_Basics = new Assignment("C_Basics", "C Basics", LocalDate.of(2022,4,10),40,100);
        Assignment C_Data_Structures = new Assignment("C_Data_Structures", "C Advanced", LocalDate.of(2022,5,10),40,100);

        // Assignments for course Java
        Assignment JavaSE = new Assignment("Java SE", "Introduction to Java Standard Edition", LocalDate.of(2022,3,20),40,100);
        Assignment Java_Spring = new Assignment("Java_Spring", "Spring", LocalDate.of(2022,3,23),40,100);
        Assignment individualProjectJava = new Assignment("Individual Project", "Individual Project Java - Spring", LocalDate.of(2022,05,20),40,100);
        Assignment GroupProjectJava = new Assignment("Group Project", "Group Project Java - Spring", LocalDate.of(2022,6,20),40,100);

        // Assignments for course JavaScript
        Assignment JavaScript = new Assignment("JavaScript", "JavaScript Basics", LocalDate.of(2022,4,15),40,100);
        Assignment individualProjectJavaScript = new Assignment("individual Project Front-End", "JavaScript", LocalDate.of(2022,5,15),40,100);
        Assignment GroupProjectJavaScript = new Assignment("Group Project Front-End", "JavaScript", LocalDate.of(2022,6,15),40,100);
//        allAssignments = new ArrayList<>();
        Collections.addAll(data_instance.allAssignments, C_Basics,C_Data_Structures, JavaSE, Java_Spring, individualProjectJava, GroupProjectJava, JavaScript, individualProjectJavaScript, GroupProjectJavaScript);


        //////////////////////////////////////////////// JAVA   ///////////////////////////////////////////////

        JAVA.addNewAssignment(C_Basics);


        JAVA.addNewAssignment(JavaSE);
        JAVA.addNewAssignment(Java_Spring);
        JAVA.addNewAssignment(individualProjectJava);
        JAVA.addNewAssignment(GroupProjectJava);

        // Other entities
        JAVA.addNewTrainer(trainer1);
        JAVA.addNewTrainer(trainer2);

        JAVA.addNewStudent(MIKE_WILLIAMS);
        MIKE_WILLIAMS.addAssignment(C_Basics);
        MIKE_WILLIAMS.addAssignment(JavaSE);
        MIKE_WILLIAMS.addAssignment(Java_Spring);
        MIKE_WILLIAMS.addAssignment(individualProjectJava);
        MIKE_WILLIAMS.addAssignment(GroupProjectJava);

        JAVA.addNewStudent(LUVENIA_CHARLES);
        LUVENIA_CHARLES.addAssignment(C_Basics);
        LUVENIA_CHARLES.addAssignment(JavaSE);
        LUVENIA_CHARLES.addAssignment(Java_Spring);
        LUVENIA_CHARLES.addAssignment(individualProjectJava);
        LUVENIA_CHARLES.addAssignment(GroupProjectJava);

        JAVA.addNewStudent(JOHN_TRAVOLTA);
        JOHN_TRAVOLTA.addAssignment(C_Basics);
        JOHN_TRAVOLTA.addAssignment(JavaSE);
        JOHN_TRAVOLTA.addAssignment(Java_Spring);
        JOHN_TRAVOLTA.addAssignment(individualProjectJava);
        JOHN_TRAVOLTA.addAssignment(GroupProjectJava);


        JAVA.addNewStudent(MARY_TYLER);
        MARY_TYLER.addAssignment(C_Basics);
        MARY_TYLER.addAssignment(JavaSE);
        MARY_TYLER.addAssignment(Java_Spring);
        MARY_TYLER.addAssignment(individualProjectJava);
        MARY_TYLER.addAssignment(GroupProjectJava);


        JAVA.addNewStudent(HELEN_ROSE);
        HELEN_ROSE.addAssignment(C_Basics);
        HELEN_ROSE.addAssignment(JavaSE);
        HELEN_ROSE.addAssignment(Java_Spring);
        HELEN_ROSE.addAssignment(individualProjectJava);
        HELEN_ROSE.addAssignment(GroupProjectJava);

        //////////////////////////////////////////////// C ////////////////////////////////////////////


        C_Programming.addNewAssignment(C_Basics);
        C_Programming.addNewAssignment(C_Data_Structures);


        C_Programming.addNewTrainer(trainer4);
        C_Programming.addNewTrainer(trainer5);

        C_Programming.addNewStudent(HELEN_ROSE);    //st5 helen rose is in both courses java and c
        HELEN_ROSE.addAssignment(C_Basics);
        HELEN_ROSE.addAssignment(C_Data_Structures);

        C_Programming.addNewStudent(CHRIS_ROBINSON);
        CHRIS_ROBINSON.addAssignment(C_Basics);
        CHRIS_ROBINSON.addAssignment(C_Data_Structures);

        C_Programming.addNewStudent(DOLPH_MOE);
        DOLPH_MOE.addAssignment(C_Basics);
        DOLPH_MOE.addAssignment(C_Data_Structures);

        C_Programming.addNewStudent(JACK_ARTIE);
        JACK_ARTIE.addAssignment(C_Basics);
        JACK_ARTIE.addAssignment(C_Data_Structures);

        C_Programming.addNewStudent(TYE_GERALD);
        TYE_GERALD.addAssignment(C_Basics);
        TYE_GERALD.addAssignment(C_Data_Structures);

        C_Programming.addNewStudent(ANDERSON_ABE);
        ANDERSON_ABE.addAssignment(C_Basics);
        ANDERSON_ABE.addAssignment(C_Data_Structures);


        //////////////////////////////////////////////// JAVASCRIPT ////////////////////////////////////////////

        JAVASCRIPT.addNewAssignment(C_Basics);
        JAVASCRIPT.addNewAssignment(JavaScript);
        JAVASCRIPT.addNewAssignment(individualProjectJavaScript);
        JAVASCRIPT.addNewAssignment(GroupProjectJavaScript);


        JAVASCRIPT.addNewTrainer(trainer3);

        JAVASCRIPT.addNewStudent(ANDERSON_ABE);         // Anderson Abe is in C and JAVASCRIPT
        ANDERSON_ABE.addAssignment(C_Basics);
        ANDERSON_ABE.addAssignment(JavaScript);
        ANDERSON_ABE.addAssignment(individualProjectJavaScript);
        ANDERSON_ABE.addAssignment(GroupProjectJavaScript);

        JAVASCRIPT.addNewStudent(MIKE_WILLIAMS);        // Mike Williams is in Java and JAVASCRIPT
        MIKE_WILLIAMS.addAssignment(C_Basics);
        MIKE_WILLIAMS.addAssignment(JavaScript);
        MIKE_WILLIAMS.addAssignment(individualProjectJavaScript);
        MIKE_WILLIAMS.addAssignment(GroupProjectJavaScript);

        JAVASCRIPT.addNewStudent(WILLIAM_EARNEST);
        WILLIAM_EARNEST.addAssignment(C_Basics);
        WILLIAM_EARNEST.addAssignment(JavaScript);
        WILLIAM_EARNEST.addAssignment(individualProjectJavaScript);
        WILLIAM_EARNEST.addAssignment(GroupProjectJavaScript);

        JAVASCRIPT.addNewStudent(NICOLAS_WEBSTER);
        NICOLAS_WEBSTER.addAssignment(C_Basics);
        NICOLAS_WEBSTER.addAssignment(JavaScript);
        NICOLAS_WEBSTER.addAssignment(individualProjectJavaScript);
        NICOLAS_WEBSTER.addAssignment(GroupProjectJavaScript);

        JAVASCRIPT.addNewStudent(CAITLYN_MERYL);
        CAITLYN_MERYL.addAssignment(C_Basics);
        CAITLYN_MERYL.addAssignment(JavaScript);
        CAITLYN_MERYL.addAssignment(individualProjectJavaScript);
        CAITLYN_MERYL.addAssignment(GroupProjectJavaScript);

    }
}

package models;

import data.Data;


public class PrivateSchool {
    private String name;

    final int numOfCourses = 4;

    Data data_instance = Data.getData_instance();

    public PrivateSchool(String name)  {
        this.name = name;
        System.out.print("Please insert data for 4 Courses : ");

        for(int i = 0; i < numOfCourses; i++) {
            data_instance.allCourses.add(new Course());
        }
    }

    @Override
    public String toString() {
        return "=============================" + '\n' +
                "PrivateSchool " +
                "Name = " + name + '\n' + '\n' +
                '}';
    }
}

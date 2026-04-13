package com.klu;
import java.util.List;
import java.util.Set;
import java.util.Map;
public class Student {
    private int id;
    private double fee;
    private boolean active;

    // Wrapper classes
    private Integer age;
    private Double marks;

    // String
    private String name;

    // Array
    private String[] skills;

    // Collections
    private List<String> subjects;
    private Set<String> hobbies;
    private Map<String, Integer> semesterMarks;

    // Non-primitive
    private Course course;

    // Constructor DI (ALL TYPES)
    public Student(
            int id,
            String name,
            double fee,
            boolean active,
            Integer age,
            Double marks,
            String[] skills,
            List<String> subjects,
            Set<String> hobbies,
            Map<String, Integer> semesterMarks,
            Course course) 
{

        this.id = id;
        this.name = name;
        this.fee = fee;
        this.active = active;
        this.age = age;
        this.marks = marks;
        this.skills = skills;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.semesterMarks = semesterMarks;
        this.course = course;
    }

    public void display() {
        System.out.println("ID        : " + id);
        System.out.println("Name      : " + name);
        System.out.println("Fee       : " + fee);
        System.out.println("Active    : " + active);
        System.out.println("Age       : " + age);
        System.out.println("Marks     : " + marks);

        System.out.println("Skills:");
        for (String s : skills) {
            System.out.println(" - " + s);
        }

        System.out.println("Subjects  : " + subjects);
        System.out.println("Hobbies   : " + hobbies);
        System.out.println("Semester Marks: " + semesterMarks);

        System.out.println("Course    : " +
                course.getCourseName() + " (" + course.getDuration() + " months)");
    }


}

package algomaster.association.onlinecourseplatform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Course {
    private String title;
    private Instructor instructor;
    private Set<Student> students = new HashSet<>();

    public Course(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.setEnrolledCourse(this);
        }
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        instructor.addCourse(this);
    }

    public Instructor getInstructor(){
        return this.instructor;
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }
}

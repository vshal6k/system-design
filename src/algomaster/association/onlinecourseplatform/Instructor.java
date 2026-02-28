package algomaster.association.onlinecourseplatform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Instructor {
    private String name;
    private Set<Course> courses = new HashSet<>();

    public Instructor(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setInstructor(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Course> getCourses(){
        return new ArrayList<>(courses);
    }
}

package algomaster.association.onlinecourseplatform;

public class Student {
    private String name;
    private Course enrolledCourse;

    public Student(String name){
        this.name = name;
    }

    public String getInstructorName(){
        return this.enrolledCourse.getInstructor().getName();
    }

    public void setEnrolledCourse(Course course){
        this.enrolledCourse = course;
    }

    public String getName(){
        return this.name;
    }
}

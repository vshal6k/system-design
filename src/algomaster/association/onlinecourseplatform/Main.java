package algomaster.association.onlinecourseplatform;

public class Main {
    public static void main(String[] args) {
        Instructor alice = new Instructor("Alice");
        Course dsa = new Course("Data Structures");
        Course sysDesign = new Course("System Design");

        alice.addCourse(dsa);
        alice.addCourse(sysDesign);

        Student bob = new Student("Bob");
        Student charlie = new Student("Charlie");

        dsa.enrollStudent(bob);
        dsa.enrollStudent(charlie);
        sysDesign.enrollStudent(charlie);

        System.out.println(alice.getName() + "'s courses:");
        for (Course c : alice.getCourses())
            System.out.println("  - " + c.getTitle());

        System.out.println("Students in " + dsa.getTitle() + ":");
        for (Student s : dsa.getStudents())
            System.out.println("  - " + s.getName());

        System.out.println(bob.getName() + "'s instructor: " + bob.getInstructorName());
    }
}

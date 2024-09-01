import java.util.ArrayList;
import java.util.List;

public class CourseManagementSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseManagementSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            student.enrollCourse(course);
            System.out.println(student.getStudentName() + " has been enrolled in " + course.getCourseName());
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    public void displayStudentCourses(String studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.println("Courses for " + student.getStudentName() + ":");
            for (Course course : student.getEnrolledCourses()) {
                System.out.println(course);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // Adding courses
        Course course1 = new Course("C101", "Introduction to Java", 4);
        Course course2 = new Course("C102", "Data Structures", 3);
        cms.addCourse(course1);
        cms.addCourse(course2);

        // Adding students
        Student student1 = new Student("S101", "Alice");
        Student student2 = new Student("S102", "Bob");
        cms.addStudent(student1);
        cms.addStudent(student2);

        // Enroll students in courses
        cms.enrollStudentInCourse("S101", "C101");
        cms.enrollStudentInCourse("S101", "C102");
        cms.enrollStudentInCourse("S102", "C101");

        // Display enrolled courses
        cms.displayStudentCourses("S101");
        cms.displayStudentCourses("S102");
    }
}

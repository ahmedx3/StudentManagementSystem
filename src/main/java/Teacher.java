import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teacher extends Person {
    private final int id;

    private static int count = 0;
    public static boolean isPrinted = false;

    private static final Logger logger = LogManager.getLogger(Teacher.class);

    /////////// Constructors ///////////

    public Teacher() {
        super();
        this.id = count;
        count++;
    }

    public Teacher(String name, String email, String mobileNumber) {
        super(name, email, mobileNumber);
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    void getStudentsInCourse(int courseID) {
        List<Student> students;

        Course course = Database.getInstance().getCourses().getOrDefault(courseID, null);

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        students = course.getEnrolledStudents();

        System.out.println("Students in course " + Database.getInstance().getCourseByID(courseID).getCodeName() + " are:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    void getStudentData(int studentID) {
        Student student = Database.getInstance().getStudents().getOrDefault(studentID, null);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println(student);
    }

    void addAssignment(Assignment assignment) {
        Database.getInstance().getAssignments().add(assignment);
        logger.info("Assignment " + assignment.getId() + " added to database");
        System.out.println("Assignment added successfully!");
    }

    void submitStudentsAttendance(CourseAttendance[] courseAttendances) {
        for (CourseAttendance courseAttendance : courseAttendances) {
            Database.getInstance().getCourseAttendances().add(courseAttendance);
        }
    }

    void submitStudentsAttendance(CourseAttendance courseAttendance) {
        Database.getInstance().getCourseAttendances().add(courseAttendance);
    }

    void getAllCourses() {
        for (Map.Entry<Integer, Course> entry : Database.getInstance().getCourses().entrySet()) {
            System.out.println(entry.getValue());
        }
        Course.isPrinted = false;
    }

    void viewStudentsAssignedCourses() {
        System.out.println("Students Enrolled Courses are:");
        // Print all students with their corresponding courses
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s| %-20s%n", "Student Name", "Courses"));

        for (Map.Entry<Integer, Student> student : Database.getInstance().getStudents().entrySet()) {
            String studentName = student.getValue().getName();
            sb.append(String.format("%-20s|", studentName));
            List<Course> courses = student.getValue().enrolledCourses;

            for (Course course : courses) {
                sb.append(String.format("%-8s,", course.getCodeName()));
            }

            sb.append(String.format("%n"));
        }

        System.out.println(sb);

    }

    void createCourse(String codeName) {
        Course course = new Course(codeName, this);
        Database.getInstance().getCourses().put(course.getId(), course);
        logger.info("Course " + course.getId() + " added to database");
        System.out.println("Course Added Successfully!\n");
    }

    /////////// Setters and Getters ///////////

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    ///////////// ToString /////////////


    @Override
    public String toString() {
        // Create a string builder and append the name, email and mobile number in format of table
        StringBuilder sb = new StringBuilder();

        if (!isPrinted) {
            sb.append(ConsoleColors.BLUE);
            sb.append(String.format("%-20s| %-20s| %-20s|%n", "Name", "Email", "Mobile Number"));
            sb.append(ConsoleColors.RESET);
            isPrinted = true;
        }

        sb.append(ConsoleColors.GREEN);
        sb.append(String.format("%-20s| %-20s| %-20s|%n", name, email, mobileNumber));
        sb.append(ConsoleColors.RESET);
        return sb.toString();
    }
}

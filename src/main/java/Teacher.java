import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teacher extends Person {
    private final int id;

    private static int count = 0;

    /////////// Constructors ///////////

    public Teacher() {
        super();
        this.id = count;
        count++;
    }

    public Teacher(String name, String email, String mobileNumber) {
        super(name,email,mobileNumber);
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
        System.out.println(students);
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
        System.out.println("Assignment added successfully!");
    }

    void submitStudentsAttendance(CourseAttendance[] courseAttendances) {
        for (CourseAttendance courseAttendance: courseAttendances) {
            Database.getInstance().getCourseAttendances().add(courseAttendance);
        }
    }

    void submitStudentsAttendance(CourseAttendance courseAttendance) {
        Database.getInstance().getCourseAttendances().add(courseAttendance);
    }

    void getAllCourses() {
        for (Map.Entry<Integer,Course> entry : Database.getInstance().getCourses().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    void viewStudentsAssignedCourses() {
        System.out.println("Students Enrolled Courses are:");
        for (Map.Entry<Integer,Student> entry : Database.getInstance().getStudents().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    void createCourse(String codeName) {
        Course course = new Course(codeName,this);
        Database.getInstance().getCourses().put(course.getId(),course);
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

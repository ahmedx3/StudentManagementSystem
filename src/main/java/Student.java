import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    //TODO: Add UUID (in any attribute)
    //TODO: properties from file (key: value)
    private final int id;
    private int age;
    private String address;
    private Gender gender;

    private static int count = 0;

    public static boolean isPrinted = false;

    public final List<Course> enrolledCourses = new ArrayList<>();

    /////////// Constructors ///////////

    public Student() {
        this("Undefined", "Undefined", "0"
                , 0, "Undefined", Gender.MALE);
    }

    public Student(String name, String email, String mobileNumber, int age, String address, Gender gender) {
        super(name, email, mobileNumber);
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    void enrollInCourse(Course c) {

        this.enrolledCourses.add(c);
        Course course = Database.getInstance().getCourses().getOrDefault(c.getId(), null);
        course.enrollStudent(this);

        System.out.println("Enrolled Successfully!\n");
    }

    void viewEnrolledCourses() {
        System.out.println("My enrolled courses are:");
        for (Course c : enrolledCourses) {
            System.out.println(c);
        }
    }

    void viewAssignments(int courseID) {
        for (Assignment assignment : Database.getInstance().getAssignments()) {
            if (assignment.getCourseId() == courseID) {
                System.out.println(assignment);
            }
        }
        Assignment.isPrinted = false;
    }

    void submitAssignment(AssignmentSubmission assignmentSubmission) {
        Database.getInstance().getAssignmentSubmissions().add(assignmentSubmission);
    }

    /////////// Setters and Getters ///////////

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /////////// To String ///////////


    @Override
    public String toString() {
        // Create a string builder and append the name, email, mobile number, age , address , gender in format of table
        StringBuilder sb = new StringBuilder();
        if (!isPrinted) {
            sb.append(ConsoleColors.BLUE);
            sb.append(String.format("%-20s| %-20s| %-20s| %-20s| %-20s| %-20s|%n", "Name", "Email", "Mobile Number", "Age", "Address", "Gender"));
            sb.append(ConsoleColors.RESET);
            isPrinted = true;
        }

        sb.append(ConsoleColors.GREEN);
        sb.append(String.format("%-20s| %-20s| %-20s| %-20d| %-20s| %-20s|%n", name, email, mobileNumber, age, address, gender));
        sb.append(ConsoleColors.RESET);

        return sb.toString();
    }
}
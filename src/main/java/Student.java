import java.util.ArrayList;
import java.util.List;

public class Student {
    private final int id;
    private String name;
    private String email;
    private String mobileNumber;
    private int age;
    private String address;
    private Gender gender;

    private static int count = 0;

    private final List<Course> enrolledCourses = new ArrayList<>();

    /////////// Constructors ///////////

    public Student() {
        this("Undefined","Undefined","0"
        ,0,"Undefined",Gender.MALE);
    }

    public Student(String name, String email, String mobileNumber, int age , String address, Gender gender) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    void enrollInCourse(Course c) {
        this.enrolledCourses.add(c);
        for(Course course: Database.getInstance().getCourses()) {
            if(course.equals(c)) {
                course.enrollStudent(this);
            }
        }
    }

    void viewEnrolledCourses() {
        System.out.println("My enrolled courses are:");
        for (Course c: enrolledCourses) {
            System.out.println(c);
        }
    }

    void viewAssignments(int courseID) {
        for(Assignment assignment: Database.getInstance().getAssignments()) {
            if(assignment.getCourseId() == courseID) {
                System.out.println(assignment);
            }
        }
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
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }
}

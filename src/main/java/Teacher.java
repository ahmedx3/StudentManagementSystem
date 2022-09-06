import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private final int id;
    private String name;
    private String email;
    private String mobileNumber;

    private static int count = 0;

    /////////// Constructors ///////////

    public Teacher() {
        this("Undefined","Undefined","0");
    }

    public Teacher(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    List<Student> getStudentsInCourse(int courseID) {
        List<Student> students = new ArrayList<>();
        for (Course c: Database.courses) {
            if (c.getId() == courseID) {
                students = c.getEnrolledStudents();
            }
        }
        return students;
    }
    
    void getStudentData(int studentID) {
        for (Student s : Database.students) {
            if (s.getId() == studentID) {
                System.out.println(s);
            }
        }
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

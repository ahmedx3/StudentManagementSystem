import java.util.ArrayList;
import java.util.List;

public class Course {
    private final int id;
    private String codeName;
    private Teacher teacher;

    private List<Student> enrolledStudents = new ArrayList<>();

    private static int count = 0;

    public Course() {
        this("Undefined",new Teacher());
    }

    public Course(String codeName, Teacher teacher) {
        this.codeName = codeName;
        this.teacher = teacher;
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    public void enrollStudent(Student s) {
        this.enrolledStudents.add(s);
    }

    public void viewEnrolledStudents() {
        System.out.println("Enrolled students are: ");
        for (Student s: enrolledStudents) {
            System.out.println(s);
        }
    }

    /////////// Setters and Getters ///////////

    public int getId() {
        return id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    ///////////// ToString /////////////

    @Override
    public String toString() {
        return "Course{" +
                "codeName='" + codeName + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}

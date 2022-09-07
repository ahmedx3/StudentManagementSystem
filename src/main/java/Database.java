import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database database_instance = null;

    // TODO: use hashmap
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();
    private final List<AssignmentSubmission> assignmentSubmissions = new ArrayList<>();
    private final List<CourseAttendance> courseAttendances = new ArrayList<>();

    private Database()
    {
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public List<CourseAttendance> getCourseAttendances() {
        return courseAttendances;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public static Database getInstance()
    {
        if (database_instance == null)
            database_instance = new Database();

        return database_instance;
    }

}

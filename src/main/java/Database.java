import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {

    private static Database database_instance = null;

    // TODO: use hashmap
    private final HashMap<Integer,Teacher> teachers = new HashMap<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();
    private final List<AssignmentSubmission> assignmentSubmissions = new ArrayList<>();
    private final List<CourseAttendance> courseAttendances = new ArrayList<>();

    private Database()
    {
    }

    public static Database getInstance()
    {
        if (database_instance == null)
            database_instance = new Database();

        return database_instance;
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

    public HashMap<Integer,Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    Teacher getTeacherByID(int id) {
        return teachers.getOrDefault(id, null);
    }

    Student getStudentByID(int id) {
        for (Student student: students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    Course getCourseByID(int id) {
        for (Course course: courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    Assignment getAssignmentByID(int id) {
        for (Assignment assignment: assignments) {
            if (assignment.getId() == id) {
                return assignment;
            }
        }
        return null;
    }
}

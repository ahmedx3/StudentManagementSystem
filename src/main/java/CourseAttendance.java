import java.util.Date;

public class CourseAttendance {
    private final int id;
    private int courseId;
    private int studentId;
    private Date attendanceDate;
    private String status;

    private static int count = 0;

    public CourseAttendance() {
        this(-1,-1,new Date(),"Undefined");
    }

    public CourseAttendance(int courseId, int studentId, Date attendanceDate, String status) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
        this.id = count;
        count++;
    }

    /////////// Setters and Getters ///////////

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

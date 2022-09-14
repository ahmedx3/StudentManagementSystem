import java.util.Date;

public class AssignmentSubmission {
    private int assignmentId;
    private int studentId;
    private int courseId;
    private Date submissionDate;
    private String assignmentContentSubmitted;
    private float assignmentMarks;

    /////////// Constructors ///////////

    public AssignmentSubmission() {
        this(-1,-1,-1,new Date(),"Undefined",0.0f);
    }

    public AssignmentSubmission(int assignmentId, int studentId, int courseId, Date submissionDate, String assignmentContentSubmitted, float assignmentMarks) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.submissionDate = submissionDate;
        this.assignmentContentSubmitted = assignmentContentSubmitted;
        this.assignmentMarks = assignmentMarks;
    }

    /////////// Setters and Getters ///////////

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAssignmentContentSubmitted() {
        return assignmentContentSubmitted;
    }

    public void setAssignmentContentSubmitted(String assignmentContentSubmitted) {
        this.assignmentContentSubmitted = assignmentContentSubmitted;
    }

    public float getAssignmentMarks() {
        return assignmentMarks;
    }

    public void setAssignmentMarks(float assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }
}

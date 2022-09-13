import java.util.Date;

public class Assignment {
    private final int id;
    private String description;
    private int courseId;
    private Date dueDate;

    private static int count = 0;

    public static boolean isPrinted = false;

    /////////// Constructors ///////////

    public Assignment() {
        this("Undefined",-1,new Date());
    }

    public Assignment(String description, int courseId, Date dueDate) {
        this.description = description;
        this.courseId = courseId;
        this.dueDate = dueDate;
        this.id = count;
        count++;
    }

    /////////// Setters and Getters ///////////

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!isPrinted) {
            sb.append(String.format("%-20s| %-20s%n", "Description", "Due Date"));
            isPrinted = true;
        }

        sb.append(String.format("%-20s| %-20s|%n", description, dueDate.toString()));
        return sb.toString();
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

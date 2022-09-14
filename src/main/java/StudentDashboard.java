import java.util.Date;
import java.util.Scanner;

public class StudentDashboard implements Dashboard {
    @Override
    public void dashboard() throws NotFoundException {
        System.out.println("============ Student Dashboard ============");

        System.out.println("0 - Enroll in Course");
        System.out.println("1 - View Enrolled Courses");
        System.out.println("2 - View Assignments");
        System.out.println("3 - Submit Assignment");
        System.out.println("4 - Logout");

        Scanner scan = new Scanner(System.in);
        int studentMode = scan.nextInt();

        switch (studentMode) {
            case 0:
                enrollInCourse();
                break;
            case 1:
                viewEnrolledCourses();
                break;
            case 2:
                viewAssignments();
                break;
            case 3:
                submitAssignment();
            case 4:
                InteractiveInterface.logout();
                break;
        }
    }

    private void enrollInCourse() throws NotFoundException {
        System.out.println("============ Enroll In Course ============");

        System.out.print("Enter course ID to enroll: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Course course = Database.getInstance().getCourseByID(id);

        if (course == null) {
            throw new NotFoundException("Course", id);
        }

        InteractiveInterface.student.enrollInCourse(course);
    }

    private void viewEnrolledCourses() {
        System.out.println("============ My Enrolled Courses ============");

        InteractiveInterface.student.viewEnrolledCourses();
    }

    private void viewAssignments() throws NotFoundException {
        System.out.println("============ View Assignments ============");

        System.out.print("Enter course ID to view: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Course course = Database.getInstance().getCourseByID(id);

        if (course == null) {
            throw new NotFoundException("Course", id);
        }

        InteractiveInterface.student.viewAssignments(id);
    }

    private void submitAssignment() throws NotFoundException {
        System.out.println("============ Submit Assignment ============");

        System.out.print("Enter assignment ID: ");
        Scanner scan = new Scanner(System.in);
        int assignmentID = scan.nextInt();

        Assignment assignment = Database.getInstance().getAssignmentByID(assignmentID);

        if (assignment == null) {
            throw new NotFoundException("Assignment", assignmentID);
        }

        System.out.print("Enter course ID : ");
        int courseID = scan.nextInt();

        Course course = Database.getInstance().getCourseByID(courseID);

        if (course == null) {
            throw new NotFoundException("Course", courseID);
        }

        Date date = new Date();

        System.out.print("Enter assignment content : ");
        scan.nextLine();
        String assignmentContent = scan.nextLine();

        System.out.print("Enter marks : ");
        int marks = scan.nextInt();

        InteractiveInterface.student.submitAssignment(new AssignmentSubmission(assignmentID, InteractiveInterface.student.getId(), courseID, date, assignmentContent, marks));
    }

}

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class TeacherDashboard implements Dashboard {
    @Override
    public void dashboard() throws NotFoundException {
        System.out.println("============ Teacher Dashboard ============");

        System.out.println("0 - Create course");
        System.out.println("1 - View Students Assigned Course");
        System.out.println("2 - View Students In Course");
        System.out.println("3 - View All Courses");
        System.out.println("4 - View Student Data");
        System.out.println("5 - Add Assignment");
        System.out.println("6 - Submit Students Attendance");
        System.out.println("7 - Logout");

        Scanner scan = new Scanner(System.in);
        int teacherMode = scan.nextInt();

        switch (teacherMode) {
            case 0:
                createCourse();
                break;
            case 1:
                viewStudentsAssignedCourses();
                break;
            case 2:
                getStudentsInCourse();
                break;
            case 3:
                getAllCourses();
                break;
            case 4:
                getStudentData();
                break;
            case 5:
                addAssignment();
                break;
            case 6:
                submitStudentsAttendance();
                break;
            case 7:
                InteractiveInterface.logout();
                break;
        }
    }

    private void createCourse() {
        System.out.println("============ Create Course ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code name: ");
        String codeName = sc.nextLine();

        InteractiveInterface.teacher.createCourse(codeName);
    }

    private void viewStudentsAssignedCourses() {
        System.out.println("============ View Students Assigned Courses ============");

        InteractiveInterface.teacher.viewStudentsAssignedCourses();
    }

    private void getStudentsInCourse() throws NotFoundException {
        System.out.println("============ View Students In Course ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int id = sc.nextInt();

        Course course = Database.getInstance().getCourseByID(id);

        if (course == null) {
            throw new NotFoundException("Course", id);
        }

        InteractiveInterface.teacher.getStudentsInCourse(id);
    }

    private void getAllCourses() {
        System.out.println("============ View All Courses ============");

        InteractiveInterface.teacher.getAllCourses();
    }

    private void getStudentData() throws NotFoundException {
        System.out.println("============ View Student Data ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            throw new NotFoundException("Student", id);
        }

        InteractiveInterface.teacher.getStudentData(id);
    }

    private void addAssignment() throws NotFoundException {
        System.out.println("============ Add Assignment ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int id = sc.nextInt();

        Course course = Database.getInstance().getCourseByID(id);

        if (course == null) {
            throw new NotFoundException("Course", id);
        }

        System.out.print("Enter Assignment Description: ");
        sc.nextLine();
        String description = sc.nextLine();

        System.out.print("Enter Due Date (YYYY-MM-DD): ");
        String dateString = sc.nextLine();
        LocalDate localDate = LocalDate.parse(dateString);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        InteractiveInterface.teacher.addAssignment(new Assignment(description, id, date));
    }

    private void submitStudentsAttendance() throws NotFoundException {
        System.out.println("============ Submit Student Attendance ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int courseID = sc.nextInt();

        Course course = Database.getInstance().getCourseByID(courseID);

        if (course == null) {
            throw new NotFoundException("Course", courseID);
        }

        System.out.print("Enter student ID: ");
        int studentID = sc.nextInt();

        Student student = Database.getInstance().getStudentByID(studentID);

        if (student == null) {
            throw new NotFoundException("Student", studentID);
        }

        System.out.print("Enter Attendance Date (YYYY-MM-DD): ");
        sc.nextLine();
        String dateString = sc.nextLine();
        LocalDate localDate = LocalDate.parse(dateString);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        InteractiveInterface.teacher.submitStudentsAttendance(new CourseAttendance(courseID, studentID, date, status));
    }

}

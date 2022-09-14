import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class InteractiveInterface {
    //TODO: factory design pattern

    public static Mode mode;
    public static Admin admin;
    public static Student student;
    public static Teacher teacher;

    private static final Logger logger = LogManager.getLogger(InteractiveInterface.class);

    InteractiveInterface() {
        mode = Mode.WELCOME;
    }

    public void run() {
        while (true) {
            try {
                DashboardFactory dashboardFactory = new DashboardFactory();
                switch (mode) {
                    case WELCOME:
                        welcome();
                        break;
                    case ADMIN_REGISTER:
                        adminRegister();
                        break;
                    case ADMIN_DASHBOARD:
                        dashboardFactory.getDashboard("ADMIN").dashboard();
                        break;
                    case LOGIN_SCREEN:
                        loginScreen();
                        break;
                    case STUDENT_DASHBOARD:
                        dashboardFactory.getDashboard("STUDENT").dashboard();
                        break;
                    case TEACHER_DASHBOARD:
                        dashboardFactory.getDashboard("TEACHER").dashboard();
                        break;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void welcome() {
        System.out.println("============ Welcome To Student Management System ============");
        System.out.println("Press ENTER to continue ...");

        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();

        if (readString.isEmpty()) {
            mode = Mode.ADMIN_REGISTER;
        }
    }

    public void adminRegister() {
        System.out.println("============ Create Admin Account ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();


        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))) {

            Properties prop = new Properties();
            prop.load(input);

            if (prop.getProperty("admin.name").equals(name) && prop.getProperty("admin.email").equals(email) && prop.getProperty("admin.mobileNumber").equals(mobileNumber)) {
                admin = new Admin(name, email, mobileNumber);
                mode = Mode.LOGIN_SCREEN;
            } else {
                System.out.println("Wrong credentials!");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    private void loginScreen() throws NotFoundException {
        System.out.println("============ Login ============");

        System.out.println("0 - Admin");
        System.out.println("1 - Teacher");
        System.out.println("2 - Student");

        Scanner scan = new Scanner(System.in);
        int loginMode = scan.nextInt();

        switch (loginMode) {
            case 0:
                mode = Mode.ADMIN_DASHBOARD;
                break;
            case 1:
                System.out.print("Enter your ID: ");
                Scanner scanTeacher = new Scanner(System.in);
                int teacherID = scanTeacher.nextInt();

                Teacher teacher = Database.getInstance().getTeacherByID(teacherID);

                if (teacher == null) {
                    throw new NotFoundException("Teacher", teacherID);
                }

                this.teacher = teacher;
                mode = Mode.TEACHER_DASHBOARD;
                break;
            case 2:
                System.out.print("Enter your ID: ");
                Scanner scanStudent = new Scanner(System.in);
                int studentID = scanStudent.nextInt();

                Student student = Database.getInstance().getStudentByID(studentID);

                if (student == null) {
                    throw new NotFoundException("Student", studentID);
                }

                this.student = student;
                mode = Mode.STUDENT_DASHBOARD;
        }
    }

    public static void logout() {
        mode = Mode.LOGIN_SCREEN;
        student = null;
        teacher = null;
    }

}

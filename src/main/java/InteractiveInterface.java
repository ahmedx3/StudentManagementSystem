import java.util.Scanner;

public class InteractiveInterface {

    private Mode mode;
    private Admin admin;
    private Student student;
    private Teacher teacher;

    InteractiveInterface() {
        mode = Mode.WELCOME;
    }

    public void run() {
        while (true) {
            switch(mode) {
                case WELCOME:
                    welcome();
                    break;
                case ADMIN_REGISTER:
                    adminRegister();
                    break;
                case ADMIN_DASHBOARD:
                    adminDashboard();
                    break;
                case LOGIN_SCREEN:
                    loginScreen();
                    break;
                case STUDENT_DASHBOARD:
                    studentDashboard();
                    break;
                case TEACHER_DASHBOARD:
                    teacherDashboard();
            }
        }
    }

    public void welcome() {
        System.out.println("============ Welcome to Student Management System ============");
        System.out.println("Press ENTER to continue ...");

        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();

        if (readString.isEmpty()) {
            mode = Mode.ADMIN_REGISTER;
        }
    }

    public void adminRegister() {
        System.out.println("============ Create admin account ============");

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        admin = new Admin(name,email,mobileNumber);

        mode = Mode.ADMIN_DASHBOARD;
    }

    public void adminDashboard() {
        System.out.println("============ Admin Dashboard ============");

        System.out.println("0 - Add Teacher");
        System.out.println("1 - Remove Teacher");
        System.out.println("2 - View All Teachers");
        System.out.println("3 - View Teacher Details");
        System.out.println("4 - Update Teacher Data");
        System.out.println("5 - Add Student");
        System.out.println("6 - Remove Student");
        System.out.println("7 - View All Students");
        System.out.println("8 - View Student Details");
        System.out.println("9 - Update Student Data");
        System.out.println("10 - Logout");

        Scanner scan = new Scanner(System.in);
        int adminMode = scan.nextInt();

        switch (adminMode) {
            case 0:
                addTeacher();
                break;
            case 1:
                removeTeacher();
                break;
            case 2:
                viewAllTeachers();
                break;
            case 3:
                viewTeacherDetails();
                break;
            case 4:
                updateTeacherData();
                break;
            case 5:
                addStudent();
                break;
            case 6:
                removeStudent();
                break;
            case 7:
                viewAllStudents();
                break;
            case 8:
                viewStudentDetails();
                break;
            case 9:
                updateStudentData();
                break;
            case 10:
                logout();
                break;
        }
    }

    private void loginScreen() {
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
                int techerID = scanTeacher.nextInt();

                Teacher teacher = Database.getInstance().getTeacherByID(techerID);

                if (teacher == null) {
                    System.out.println("Not found!\n");
                    break;
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
                    System.out.println("Not found!\n");
                    break;
                }

                this.student = student;
                mode = Mode.STUDENT_DASHBOARD;
        }
    }

    private void logout() {
        mode = Mode.LOGIN_SCREEN;
        this.student = null;
        this.teacher = null;
    }

    private void updateStudentData() {
        System.out.println("============ Update student data ============");

        System.out.print("Student id to update: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            System.out.println("Student not found!\n");
            return;
        }

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        admin.updateStudentData(student,name,email,mobileNumber);
    }

    private void viewStudentDetails() {
        System.out.println("============ View student details ============");
        System.out.print("Student id to view: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            System.out.println("Student not found!\n");
            return;
        }

        admin.viewStudentDetails(student);
    }

    private void viewAllStudents() {
        System.out.println("============ View all students ============");
        admin.viewAllStudents();
        System.out.println();
    }

    private void removeStudent() {
        System.out.println("============ Remove Student ============");
        Scanner sc= new Scanner(System.in);
        System.out.print("Student id to remove: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            System.out.println("Student not found!\n");
            return;
        }

        admin.removeStudent(student);
    }

    private void addStudent() {
        System.out.println("============ Add student ============");

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter address: ");
        sc.nextLine();
        String address = sc.nextLine();
        System.out.print("Enter gender (M or F): ");
        String genderString = sc.nextLine();
        Gender gender = ((genderString.toUpperCase().equals("M")) ? Gender.MALE : Gender.FEMALE);

        Student student = new Student(name,email,mobileNumber,age,address,gender);

        admin.addStudent(student);
    }

    private void updateTeacherData() {
        System.out.println("============ Update teacher data ============");

        System.out.print("Teacher id to update: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Teacher teacher = Database.getInstance().getTeacherByID(id);

        if (teacher == null) {
            System.out.println("Teacher not found!\n");
            return;
        }

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        admin.updateTeacherData(teacher,name,email,mobileNumber);
    }

    private void viewTeacherDetails() {
        System.out.println("============ View teacher details ============");
        System.out.print("Teacher id to view: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Teacher teacher = Database.getInstance().getTeacherByID(id);

        if (teacher == null) {
            System.out.println("Teacher not found!\n");
            return;
        }

        admin.viewTeacherDetails(teacher);
    }

    private void viewAllTeachers() {
        System.out.println("============ View all teachers ============");
        admin.viewAllTeachers();
        System.out.println();
    }

    private void removeTeacher() {
        System.out.println("============ Remove Teacher ============");

        System.out.print("Teacher id to remove: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Teacher teacher = Database.getInstance().getTeacherByID(id);

        if (teacher == null) {
            System.out.println("Teacher not found!\n");
            return;
        }

        admin.removeTeacher(teacher);
    }

    private void addTeacher() {
        System.out.println("============ Add Teacher ============");

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        Teacher teacher = new Teacher(name,email,mobileNumber);

        admin.addTeacher(teacher);
    }

    private void studentDashboard() {
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
            case 4:
                logout();
                break;
        }
    }

    private void enrollInCourse() {
        System.out.println("============ Enroll in course ============");

        System.out.print("Enter course ID to enroll: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Course course = Database.getInstance().getCourseByID(id);

        if (course == null) {
            System.out.println("Course not found!\n");
            return;
        }

        this.student.enrollInCourse(course);
    }

    private void teacherDashboard() {
        System.out.println("============ Teacher Dashboard ============");

        System.out.println("0 - Create course");
        System.out.println("1 - View Students Assigned Course");
        System.out.println("2 - Get Students In Course");
        System.out.println("3 - Get All Courses");
        System.out.println("4 - Get Student Data");
        System.out.println("5 - Add Assignment");
        System.out.println("6 - Submit Students Attendance");
        System.out.println("7 - Logout");

        Scanner scan = new Scanner(System.in);
        int teacherMode = scan.nextInt();

        switch (teacherMode) {
            case 0:
                createCourse();
                break;
            case 7:
                logout();
                break;
        }
    }

    private void createCourse() {
        System.out.println("============ Create course ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code name: ");
        String codeName = sc.nextLine();

        this.teacher.createCourse(codeName);
    }
}

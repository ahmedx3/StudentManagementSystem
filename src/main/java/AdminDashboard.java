import java.util.Scanner;

public class AdminDashboard implements Dashboard {
    @Override
    public void dashboard() throws NotFoundException {
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
                InteractiveInterface.logout();
                break;
        }
    }

    private void addTeacher() {
        System.out.println("============ Add Teacher ============");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        Teacher teacher = new Teacher(name, email, mobileNumber);

        InteractiveInterface.admin.addTeacher(teacher);
    }

    private void removeTeacher() throws NotFoundException {
        System.out.println("============ Remove Teacher ============");

        System.out.print("Teacher id to remove: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Teacher teacher = Database.getInstance().getTeacherByID(id);

        if (teacher == null) {
            throw new NotFoundException("Teacher", id);
        }

        InteractiveInterface.admin.removeTeacher(teacher);
    }

    private void viewAllTeachers() {
        System.out.println("============ View All Teachers ============");
        InteractiveInterface.admin.viewAllTeachers();
        System.out.println();
    }

    private void viewTeacherDetails() throws NotFoundException {
        System.out.println("============ View Teacher Details ============");
        System.out.print("Teacher id to view: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Teacher teacher = Database.getInstance().getTeacherByID(id);

        if (teacher == null) {
            throw new NotFoundException("Teacher", id);
        }

        InteractiveInterface.admin.viewTeacherDetails(teacher);
    }

    private void updateTeacherData() throws NotFoundException {
        System.out.println("============ Update Teacher Data ============");

        System.out.print("Teacher id to update: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Teacher teacher = Database.getInstance().getTeacherByID(id);

        if (teacher == null) {
            throw new NotFoundException("Teacher", id);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        InteractiveInterface.admin.updateTeacherData(teacher, name, email, mobileNumber);
    }

    private void addStudent() {
        System.out.println("============ Add Student ============");

        Scanner sc = new Scanner(System.in);
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

        Student student = new Student(name, email, mobileNumber, age, address, gender);

        InteractiveInterface.admin.addStudent(student);
    }

    private void removeStudent() throws NotFoundException {
        System.out.println("============ Remove Student ============");
        Scanner sc = new Scanner(System.in);
        System.out.print("Student id to remove: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            throw new NotFoundException("Student", id);
        }

        InteractiveInterface.admin.removeStudent(student);
    }

    private void viewAllStudents() {
        System.out.println("============ View All Students ============");
        InteractiveInterface.admin.viewAllStudents();
        System.out.println();
    }

    private void viewStudentDetails() throws NotFoundException {
        System.out.println("============ View Student Details ============");
        System.out.print("Student id to view: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            throw new NotFoundException("Student", id);
        }

        InteractiveInterface.admin.viewStudentDetails(student);
    }

    private void updateStudentData() throws NotFoundException {
        System.out.println("============ Update Student Data ============");

        System.out.print("Student id to update: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        Student student = Database.getInstance().getStudentByID(id);

        if (student == null) {
            throw new NotFoundException("Student", id);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        InteractiveInterface.admin.updateStudentData(student, name, email, mobileNumber);
    }

}
